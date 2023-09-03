package br.com.castello.scitinfracoes.infracoes;

import br.com.castello.scitinfracoes.infracoes.creation.InfracaoCreationDTO;
import br.com.castello.scitinfracoes.infracoes.creation.InfracaoCreationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/infracoes")
public class InfracaoController {

    private final InfracaoCreationService infracaoCreationService;

    @PostMapping
    public ResponseEntity<InfracaoCreationDTO> createInfracao(@RequestBody InfracaoCreationDTO infracaoCreationDTO) {
        return infracaoCreationService.createInfracaoCreation(infracaoCreationDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() ->ResponseEntity.unprocessableEntity().build());
    }

}
