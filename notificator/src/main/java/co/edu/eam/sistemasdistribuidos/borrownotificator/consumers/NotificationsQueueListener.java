package co.edu.eam.sistemasdistribuidos.borrownotificator.consumers;

import co.edu.eam.sistemasdistribuidos.borrownotificator.models.UserNotificationData;
import co.edu.eam.sistemasdistribuidos.borrownotificator.repositories.UserNotificationDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.json.JSONException;

@Component
public class NotificationsQueueListener {

  @Autowired
  private UserNotificationDataRepository userNotificationDataRepository;

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
  @RabbitListener(queues = "#{usersCreatedQueue.name}")
  public void receiveUserCreation(String message) {
    try {
      JSONObject jsonMessage = new JSONObject(message);

      UserNotificationData user = new UserNotificationData();
      user.setId(jsonMessage.getLong("id"));
      if(jsonMessage.has("mobileNumber")) {
        user.setMobileNumber(jsonMessage.getString("mobileNumber"));
      }else{
        user.setMobileNumber(null);
      }
      if(jsonMessage.has("email")) {
        user.setEmail(jsonMessage.getString("email"));
      }else{
        user.setEmail(null);
      }

      userNotificationDataRepository.save(user);
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
}
