package br.com.castello.scitinfracoes.infracoes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Infracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infracaoId;

    private String address;

    private Long artigoId;

    private String artigoDesc;

    private Long pontuacao;

    private String placa;
}
