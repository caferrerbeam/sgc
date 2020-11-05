package co.edu.eam.sistemasdistribuidos.sgc.processor.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

@Configuration
public class RabbitMQProcessorConfig {
    @Bean
    public Queue notificationsQueue(){
        return new Queue("notifications_queue", true);
    }

    public Queue notificationsResultQueue(){
        return new Queue("notifications_result_queue", true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_exchange");
    }

    @Bean
    public Binding bindDirectExchangeNotificationQueue(Queue notificationsQueue, DirectExchange directExchangeNotification){
        return BindingBuilder.bind(notificationsQueue).to(directExchangeNotification).with("notification");
    @Bean
    public Binding bindDirectExchangeNotificationQueue(Queue notificationsQueue, DirectExchange directExchange){
        return BindingBuilder.bind(notificationsQueue).to(directExchange).with("notification");
    }

    @Bean
    public Binding bindDirectExchangeNotificationResultQueue(Queue notificationsResultQueue, DirectExchange directExchangeNotification){
        return BindingBuilder.bind(notificationsResultQueue).to(directExchangeNotification).with("notificationsResult");
    }

}
