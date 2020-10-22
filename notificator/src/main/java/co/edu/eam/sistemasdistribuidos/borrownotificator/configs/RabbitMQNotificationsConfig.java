package co.edu.eam.sistemasdistribuidos.borrownotificator.configs;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

@Configuration
public class RabbitMQNotificationsConfig {

    @Bean
    public Queue usersCreatedQueue(){
        return new Queue("users_created_queue", true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_exchange");
    }

    @Bean
    public Binding bindDirectExchangeUsersQueue(Queue usersCreatedQueue, DirectExchange directExchange){
        return BindingBuilder.bind(usersCreatedQueue).to(directExchange).with("user_created");
    }
}
