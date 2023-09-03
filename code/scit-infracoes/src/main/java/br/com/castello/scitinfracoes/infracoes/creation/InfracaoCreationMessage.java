package br.com.castello.scitinfracoes.infracoes.creation;

import br.com.castello.scitinfracoes.messaging.Message;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InfracaoCreationMessage implements Message {

    private Long infracaoCreationId;
}
