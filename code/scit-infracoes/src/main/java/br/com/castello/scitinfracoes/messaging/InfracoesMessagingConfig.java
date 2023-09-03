package br.com.castello.scitinfracoes.messaging;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class InfracoesMessagingConfig {

    @Bean
    public Queue infracaoCreationQueue() {
        return QueueBuilder
                .durable(Queues.INFRACOES_CREATION_QUEUE)
                .deadLetterExchange("")
                .deadLetterRoutingKey(Queues.INFRACOES_CREATION_QUEUE_DLQ)
                .build();
    }

    @Bean
    public Queue infracaoCreationQueueDlq() {
        return QueueBuilder
                .durable(Queues.INFRACOES_CREATION_QUEUE_DLQ)
                .ttl(60000)
                .deadLetterExchange("")
                .deadLetterRoutingKey(Queues.INFRACOES_CREATION_QUEUE)
                .build();
    }

    @Bean
    public DirectExchange infracoesExchange() {
        return new DirectExchange(Exchanges.INFRACOES_EXCHANGE);
    }

    @Bean
    public Binding infracoesBinding() {
        return BindingBuilder
                .bind(infracaoCreationQueue())
                .to(infracoesExchange())
                .with(RoutingKeys.INFRACOES_CREATION_ROUTING_KEY);
    }

}
