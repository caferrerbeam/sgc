package co.edu.eam.sistemasdistribuidos.borrownotificator.consumers;

import org.springframework.stereotype.Component;

@Component
public class NotificationsQueueListener {


  /**
   * metodo por donde llega el mensaje que indica que mensaje se debe enviar al usuario
   *  el mensaje que se debe recibir de esta cola es:
   *    * {"user_id":"..","message":"....", borrow_request_id: "....."}
   *    * donde:
   *    * user_id es quien hizo la solicitud
   *    * message: su solicitud de prestamo fue [approbada | rechazada]
   *    * borrow_request_id: el id de la solicitud
   *  tener en cuenta que con el user_id se saca el numero telefonico y el usuario de UserNotificationDataRepository
   * @param message
   */
  public void receiveNotificationCommand(String message) {

  }

  /**
   * metodo por donde llega el mensaje indicando que se creo un nuevo usuario para guardar aca
   * su email y telefono
   * @param message
   */
  public void receiveUserCreation(String message) {

  }
}
