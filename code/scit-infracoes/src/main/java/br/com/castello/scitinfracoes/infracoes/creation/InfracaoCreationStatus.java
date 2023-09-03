package br.com.castello.scitinfracoes.infracoes.creation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum InfracaoCreationStatus {
    NEW(1L),
    PROCESSING(2L),
    COMPLETE(3L),
    ERROR(-1L);

    private Long code;

}
