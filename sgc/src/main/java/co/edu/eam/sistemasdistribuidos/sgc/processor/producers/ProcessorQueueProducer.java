package co.edu.eam.sistemasdistribuidos.sgc.processor.producers;

import co.edu.eam.sistemasdistribuidos.sgc.core.models.BorrowRequest;
import org.springframework.stereotype.Component;

@Component
public class ProcessorQueueProducer {

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
  }
}
