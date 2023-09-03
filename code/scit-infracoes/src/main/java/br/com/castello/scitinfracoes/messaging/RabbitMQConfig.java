package br.com.castello.scitinfracoes.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionNameStrategy;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Configuration
//@EnableAutoConfiguration(exclude = {RabbitAutoConfiguration.class})
//@EnableRabbit
//@Slf4j
public class RabbitMQConfig {
//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) throws Exception {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//        rabbitAdmin.afterPropertiesSet();
//        return rabbitAdmin;
//    }
//
//    @Bean
//    @Primary
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) throws  Exception {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMandatory(true);
//        rabbitTemplate.setChannelTransacted(true);
//
//        return rabbitTemplate;
//    }
//
//    @Bean
//    @ConfigurationProperties("spring.rabbitmq")
//    public RabbitProperties dataSourceProperties() {return new RabbitProperties(); }
//
//    @Bean
//    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory) throws Exception {
//        PropertyMapper map = PropertyMapper.get();
//        RabbitProperties rabbitProperties = dataSourceProperties();
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setObservationEnabled(true);
//        RabbitProperties.Listener listener = rabbitProperties.getListener();
//        if (listener != null && listener.getSimple() != null) {
//            map.from(listener.getSimple()::getConcurrency).whenNonNull().to(factory::setConcurrentConsumers);
//            map.from(listener.getSimple()::getMaxConcurrency).whenNonNull().to(factory::setMaxConcurrentConsumers);
//            map.from(listener.getSimple()::getDefaultRequeueRejected).whenNonNull().to(factory::setDefaultRequeueRejected);
//        }
//        return factory;
//    }
//
//    @Bean(name="rabbitConnectionFactory")
//    @Primary
//    public CachingConnectionFactory connectionFactory(ObjectProvider<ConnectionNameStrategy> connectionNameStrategy) throws Exception {
//        RabbitProperties map = dataSourceProperties();
//        PropertyMapper rabbitProperties = PropertyMapper.get();
//        CachingConnectionFactory factory = new CachingConnectionFactory(getRa);
//
//    }
}
