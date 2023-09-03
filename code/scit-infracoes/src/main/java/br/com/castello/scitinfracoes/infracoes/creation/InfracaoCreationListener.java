package br.com.castello.scitinfracoes.infracoes.creation;

import br.com.castello.scitinfracoes.messaging.Queues;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class InfracaoCreationListener {

    private final InfracaoCreationService infracaoCreationService;

    @RabbitListener(queues = Queues.INFRACOES_CREATION_QUEUE)
    public void listen(Message message) {
        log.info("Message received [{}]", message);
        InfracaoCreationMessage infracaoCreationMessage = getInfracaoCreation(message);
        infracaoCreationService.process(infracaoCreationMessage);
    }

    private InfracaoCreationMessage getInfracaoCreation(Message message) {
        return InfracaoCreationConverter.convert(message);
    }

}
