package co.edu.eam.sistemasdistribuidos.sgc.processor.producers;

import co.edu.eam.sistemasdistribuidos.sgc.core.models.BorrowRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ProcessorQueueProducer {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private DirectExchange directExchange;
  /**
   * MEtodo para notificar al usuario el resultado del credito.
   * el mensaje que se debe anviar a esta cola es:
   * {"user_id":"..","message":"....", borrow_request_id: "....."}
   * donde:
   * user_id es quien hizo la solicitud
   * message: su solicitud de prestamo fue [approbada | rechazada]
   * borrow_request_id: el id de la solicitud
   *
   * @param request
   */
  public void notifiedBorrowResult(BorrowRequest request) {
    //enviar como json el BorrowRequest
    try {
      JSONObject json = new JSONObject();
      json.put("user_id", request.getUserId());
      json.put("message", "su solicitud de prestamo fue "+request.getStatus());
      json.put("borrow_request_id", request.getId());
      rabbitTemplate.convertAndSend(directExchange.getName(), "notification",json.toString());

    } catch (JSONException jsonProcessingException) {
      jsonProcessingException.printStackTrace();
    }

  }
}
