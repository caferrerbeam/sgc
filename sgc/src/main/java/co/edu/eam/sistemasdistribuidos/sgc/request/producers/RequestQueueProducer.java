package co.edu.eam.sistemasdistribuidos.sgc.request.producers;

import co.edu.eam.sistemasdistribuidos.sgc.core.models.BorrowRequest;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class RequestQueueProducer {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private DirectExchange directExchange;

  /**
   * metodo para enviar al processor la solicitud para estudiar el credito
   * @param request
   */
  public void sendBorrowRequest(BorrowRequest request) throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    String borrowProcessJson = objectMapper.writeValueAsString(request);

    rabbitTemplate.convertAndSend(directExchange.getName(), "borrow_process",borrowProcessJson);
  }

}
