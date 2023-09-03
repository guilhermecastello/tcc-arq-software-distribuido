package br.com.castello.scitinfracoes.infracoes;

import br.com.castello.scitinfracoes.artigos.ArtigoDTO;
import br.com.castello.scitinfracoes.infracoes.creation.InfracaoCreation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InfracaoService {

    private final InfracaoRepository infracaoRepository;
    private final InfracaoMapper mapper;

    public Infracao createInfracao(InfracaoCreation infracaoCreation, ArtigoDTO artigoDTO) {
        Infracao infracao = mapper.map(infracaoCreation);
        infracao.setArtigoId(artigoDTO.getId());
        infracao.setArtigoDesc(artigoDTO.getArtigo());
        infracao.setPontuacao(artigoDTO.getPontuacao());
        return infracaoRepository.save(infracao);
    }
}
