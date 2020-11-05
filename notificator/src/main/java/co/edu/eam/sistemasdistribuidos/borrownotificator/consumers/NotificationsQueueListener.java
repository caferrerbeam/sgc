package co.edu.eam.sistemasdistribuidos.borrownotificator.consumers;

import co.edu.eam.sistemasdistribuidos.borrownotificator.models.UserNotificationData;
import co.edu.eam.sistemasdistribuidos.borrownotificator.repositories.UserNotificationDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import co.edu.eam.sistemasdistribuidos.borrownotificator.services.NotificatorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.json.JSONException;

import org.json.JSONObject;

import javax.print.DocFlavor;

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
  @Autowired
  private NotificatorService notificatorService;

  @RabbitListener(queues = "#{notificationsQueue.name}")
  public void receiveNotificationCommand(String message) throws Exception {
    //System.out.println("este es el mensaje que se recive de la cola notifications_queue :"+message);

    String asunto = "Notificacion de Solicitud del Prestamo";
    // String[] parts = message.split(":");
    //Long user_id = Long.parseLong(parts[1].substring(1,parts[1].length()-13));
    //String mensaje = parts[2].substring(1,parts[2].length()-23);
    //Long borrow_request_id = Long.parseLong(parts[3].substring(1,parts[3].length()-4));
    //System.out.println("esta es la parte uno user_id : "+user_id);
    //System.out.println("esta es la parte dos message : "+mensaje);
    //System.out.println("esta es la parte tres borrow_request_id : "+ borrow_request_id);

    ///nuevo metodo probrar
    JSONObject jsonMessage = new JSONObject(message);
    Long user_id = jsonMessage.getLong("user_id");
    String mensaje = jsonMessage.getString("message");
    Long borrow_request_id = jsonMessage.getLong("borrow_request_id");

    //metodo para verificar el correo
    notificatorService.notifyBorrowRequestToUser(user_id,mensaje,asunto,borrow_request_id);

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
