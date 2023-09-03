package br.com.castello.scitinfracoes.messaging;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class MessageProducer {

    private RabbitTemplate rabbitTemplate;

    private void enqueue(String message, String exchange, String routingKey) {

        rabbitTemplate.convertAndSend(exchange, routingKey, message, m ->{
            m.getMessageProperties().setCorrelationId(UUID.randomUUID().toString());
            return m;
        });
        log.info("[x] Sent message [{}]", message);
    }

    public void sendMessage(Message message, String exchange, String routingKey) {
        this.enqueue(new Gson().toJson(message), exchange, routingKey);
    }

}
