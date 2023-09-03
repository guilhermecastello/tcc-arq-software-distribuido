package br.com.castello.scitinfracoes.infracoes.creation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InfracaoCreationDTO {

    private Long infracaoCreationId;

    private Long statusId;

    private String address;

    private String artigo;

    private String placa;

}
