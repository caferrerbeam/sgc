package co.edu.eam.sistemasdistribuidos.sgc.processor.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQProcessorConfig {

    @Bean
    public Queue notificationsQueue(){
        return new Queue("notifications_queue", true);
    }

    @Bean
    public DirectExchange directExchangeNotification(){
        return new DirectExchange("direct_exchange");
    }

    @Bean
    public Binding bindDirectExchangeNotificationQueue(Queue notificationsQueue, DirectExchange directExchangeNotification){
        return BindingBuilder.bind(notificationsQueue).to(directExchangeNotification).with("notification");
    }

}
