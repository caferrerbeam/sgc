package co.edu.eam.sistemasdistribuidos.borrownotificator.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQNotificationsConfig {

    @Bean
    public Queue notificationsResultQueue(){

        return new Queue("notifications_result_queue");
    }

    //creacion de la cola que se consume
    @Bean
    public Queue notificationsQueue(){

        return new Queue("notifications_queue");
    }

    @Bean
    public DirectExchange directExchange(){

        return new DirectExchange("direct_exchange");
    }

    @Bean
    public Binding bindDirectExchangeNotifications_result_queue(Queue notificationsResultQueue,DirectExchange directExchange){

        return BindingBuilder.bind(notificationsResultQueue).to(directExchange).with("notifications_result_queue") ;
    }

    //metodo que conecta la cola que se consume
    @Bean
    public Binding bindDirectExchangeNotificationsQueue(Queue notificationsQueue,DirectExchange directExchange){

       return BindingBuilder.bind(notificationsQueue).to(directExchange).with("notifications_queue") ;
    }

}
