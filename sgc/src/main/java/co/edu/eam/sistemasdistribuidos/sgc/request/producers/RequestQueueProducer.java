package co.edu.eam.sistemasdistribuidos.sgc.request.producers;

import co.edu.eam.sistemasdistribuidos.sgc.core.models.BorrowRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestQueueProducer {

  /**
   * metodo para enviar al processor la solicitud para estudiar el credito
   * @param request
   */
  public void sendBorrowRequest(BorrowRequest request) {

  }

}
