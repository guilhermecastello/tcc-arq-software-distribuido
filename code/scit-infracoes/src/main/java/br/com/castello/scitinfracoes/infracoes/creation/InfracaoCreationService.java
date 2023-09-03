package br.com.castello.scitinfracoes.infracoes.creation;


import br.com.castello.scitinfracoes.artigos.ArtigoClientService;
import br.com.castello.scitinfracoes.artigos.ArtigoDTO;
import br.com.castello.scitinfracoes.infracoes.InfracaoRepository;
import br.com.castello.scitinfracoes.infracoes.InfracaoService;
import br.com.castello.scitinfracoes.messaging.Exchanges;
import br.com.castello.scitinfracoes.messaging.MessageProducer;
import br.com.castello.scitinfracoes.messaging.RoutingKeys;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class InfracaoCreationService {

    private final MessageProducer messageProducer;
    private final InfracaoCreationRepository infracaoCreationRepository;
    private final ArtigoClientService artigoClientService;

    private final InfracaoService infracaoService;

    private final InfracaoCreationMapper mapper;

    public Optional<InfracaoCreationDTO> createInfracaoCreation(InfracaoCreationDTO infracaoCreationDTO) {
        InfracaoCreation infracaoCreation = mapper.map(infracaoCreationDTO);
        infracaoCreation.setStatusId(InfracaoCreationStatus.NEW.getCode());
        var infracaoCreationSaved = infracaoCreationRepository.save(infracaoCreation);

        messageProducer.sendMessage(InfracaoCreationMessage
                        .builder()
                        .infracaoCreationId(infracaoCreationSaved.getInfracaoCreationId())
                        .build()
                , Exchanges.INFRACOES_EXCHANGE
                , RoutingKeys.INFRACOES_CREATION_ROUTING_KEY);
        return Optional.of(mapper.map(infracaoCreationSaved));
    }

    public void process(InfracaoCreationMessage infracaoCreationMessage) {
            infracaoCreationRepository.findById(infracaoCreationMessage.getInfracaoCreationId())
                    .ifPresentOrElse(this::processInfracao, () -> log.info("Infracao Creation not found. infracaoCreationId={}", infracaoCreationMessage.getInfracaoCreationId()));
    }

    private void processInfracao(InfracaoCreation infracaoCreation) {
        try {
            infracaoCreation.setStatusId(InfracaoCreationStatus.PROCESSING.getCode());
            infracaoCreationRepository.save(infracaoCreation);

            artigoClientService.findArtigoByArtigo(infracaoCreation.getArtigo())
                    .ifPresentOrElse(artigoDTO -> this.createInfracao(infracaoCreation, artigoDTO),
                            () -> {throw new RuntimeException("Artigo not found.");});

            infracaoCreation.setStatusId(InfracaoCreationStatus.COMPLETE.getCode());
            infracaoCreationRepository.save(infracaoCreation);
        } catch (Exception ex) {
            infracaoCreation.setStatusId(InfracaoCreationStatus.ERROR.getCode());
            infracaoCreationRepository.save(infracaoCreation);
            throw new RuntimeException(ex.getMessage());
        }
    }

    private void createInfracao(InfracaoCreation infracaoCreation, ArtigoDTO artigoDTO) {
        infracaoService.createInfracao(infracaoCreation, artigoDTO);
    }
}
