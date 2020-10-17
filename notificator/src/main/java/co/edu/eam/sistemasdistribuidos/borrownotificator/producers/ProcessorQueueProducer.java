package co.edu.eam.sistemasdistribuidos.borrownotificator.producers;

import org.springframework.stereotype.Component;

@Component
public class ProcessorQueueProducer {

  /**
   * MEtodo para notificar enviarle al procesador de solicitud que ya fue notificado al usuario
   * el resultado del estudio..
   *
   *
   * @param objeto con laifnromacion necesaria
   */
  public void notifyBorrowRequestNotification(/*el tupo de dato lo definen uds aqui*/) {
    //enviar como json el BorrowRequest
  }
}
