package co.edu.eam.sistemasdistribuidos.sgc.request.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQRequestConfig {

    @Bean
    public Queue borrowProcessQueue(){
        return new Queue("borrow_process_queue", true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_exchange");
    }

    @Bean
    public Binding bindDirectExchangeBorrowProcessQueue(Queue borrowProcessQueue, DirectExchange directExchange){
        return BindingBuilder.bind(borrowProcessQueue).to(directExchange).with("borrow_process");
    }

}
