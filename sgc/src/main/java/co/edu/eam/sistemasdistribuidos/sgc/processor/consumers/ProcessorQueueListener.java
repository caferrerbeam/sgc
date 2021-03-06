package co.edu.eam.sistemasdistribuidos.sgc.processor.consumers;

import co.edu.eam.sistemasdistribuidos.sgc.core.models.BorrowRequest;
import co.edu.eam.sistemasdistribuidos.sgc.processor.producers.ProcessorQueueProducer;
import co.edu.eam.sistemasdistribuidos.sgc.processor.services.BorrowRequestProcessorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessorQueueListener {

  @Autowired
  private BorrowRequestProcessorService borrowRequestService;


  /**
   * metodo por donde llega el mensaje que indica que el resultado de la solicitud
   * ya fue notificada
   * @param message
   */
  @RabbitListener(queues = "#{notificationsResultQueue.name}")
  public void receiveNotificationResult(String message){
    try {
      JSONObject json = new JSONObject(message);
      borrowRequestService.setAsNotified(json.getLong("id_solicitud"));
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /**
   * metodo por donde llega la solicitud de credito para estudiar
   * @param message
   */
  @RabbitListener(queues = "#{borrowProcessQueue.name}")
  public void receiveBorrowRequest(String message) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      BorrowRequest borrowRequest = objectMapper.readValue(message, BorrowRequest.class);

      //Estudiar el mensaje
      borrowRequestService.processRequest(borrowRequest);

    }catch (JsonProcessingException jsonProcessingException){
      jsonProcessingException.printStackTrace();
    }

  }
}
