package co.edu.eam.sistemasdistribuidos.sgc.processor.consumers;

import co.edu.eam.sistemasdistribuidos.sgc.processor.services.BorrowRequestProcessorService;
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
  public void receiveNotificationResult(String message) {

  }

  /**
   * metodo por donde llega la solicitud de credito para estudiar
   * @param message
   */
  public void receiveBorrowRequest(String message) {

  }
}
