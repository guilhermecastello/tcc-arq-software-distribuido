package br.com.castello.scitartigos.artigos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Artigo {

    @Id
    private Long id;

    private String artigo;

    private String descricao;

    private Long pontuacao;

    private Long suspendeCNH;

}
