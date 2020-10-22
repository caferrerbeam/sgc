package co.edu.eam.sistemasdistribuidos.users.producers;

import co.edu.eam.sistemasdistribuidos.users.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UsersQueueProducer {

  /**
   * MEtodo para enviar a la cola de notificacion de usuario creado.
   *
   * @param user
   */

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private DirectExchange directExchange;

  public void notifyUserCreation(User user) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    String borrowProcessJson = objectMapper.writeValueAsString(user);

    rabbitTemplate.convertAndSend(directExchange.getName(), "users_process",borrowProcessJson);
  }
}