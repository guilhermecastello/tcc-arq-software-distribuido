package br.com.castello.scitinfracoes.artigos;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ArtigoDTO {

    private Long id;
    private String artigo;
    private Long pontuacao;
}
