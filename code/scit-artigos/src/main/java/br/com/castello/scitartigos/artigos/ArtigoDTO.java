package br.com.castello.scitartigos.artigos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ArtigoDTO {

    private Long id;

    private String artigo;

    private String descricao;

    private Long pontuacao;

    private Boolean suspendeCNH;

}
