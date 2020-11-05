package co.edu.eam.sistemasdistribuidos.sgc.processor.services;

import co.edu.eam.sistemasdistribuidos.sgc.core.models.BorrowRequest;
import co.edu.eam.sistemasdistribuidos.sgc.core.repositories.BorrowRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowRequestProcessorService {

  @Autowired
  private BorrowRequestRepository borrowRequestRepository;

  /**
   * metodo para revisar si se aprueba o no el credito, despues de estudiarlo
   * debe notificar el resultado por la cola de notificacion y actualizar si esta aprobado o no.
   * se aprueba un credito siguiendo estas reglas:
   * 1. si su antiguedad es menor de 6 meses, no se aprueba
   * 2. si su salario es menor del 30% del monto/numerocuotas no se aprueba
   * 3. solo se puede solicitar mas de 20 veces su salario.
   * @param request
   * @return
   */
  public boolean processRequest(BorrowRequest request) {
    return false;
  }

  /**
   * Marca la solicitud como notificada
   * @param requestId
   */
  public void setAsNotified(Long requestId) {
    BorrowRequest notifiedBorrow = borrowRequestRepository.findById(requestId).get();
    notifiedBorrow.setNotified(true);
    borrowRequestRepository.save(notifiedBorrow);
  }

}
