package co.edu.eam.sistemasdistribuidos.users.producers;

import co.edu.eam.sistemasdistribuidos.users.models.User;
import org.springframework.stereotype.Component;

@Component
public class UsersQueueProducer {

  /**
   * MEtodo para enviar a la cola de notificacion de usuario creado.
   *
   * @param user
   */
  public void notifyUserCreation(User user) {

  }
}
