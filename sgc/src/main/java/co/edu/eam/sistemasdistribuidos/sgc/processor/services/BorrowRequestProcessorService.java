package co.edu.eam.sistemasdistribuidos.sgc.processor.services;

import co.edu.eam.sistemasdistribuidos.sgc.core.models.BorrowRequest;
import co.edu.eam.sistemasdistribuidos.sgc.core.repositories.BorrowRequestRepository;
import co.edu.eam.sistemasdistribuidos.sgc.processor.producers.ProcessorQueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowRequestProcessorService {

  @Autowired
  private BorrowRequestRepository borrowRequestRepository;

  @Autowired
  private ProcessorQueueProducer processorQueueProducer;

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
    Boolean isApproved=false;

    if(request.getMonthsSeniority() < 6
            || request.getSalary() < ((request.getAmount()/request.getInstallment())*0.30d)
            || request.getAmount() <= (request.getSalary()*20)){

      request.setStatus("rejected");
    }else{
      request.setStatus("approved");
      isApproved=true;
    }
    update(request.getId(), request);
    processorQueueProducer.notifiedBorrowResult(request);

    return isApproved;
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


  public void update(Long id, BorrowRequest r){
    boolean request = borrowRequestRepository.existsById(id);
    if(!request)
      throw new RuntimeException("No existe una solicitud con ID: "+id);

    r.setId(id);
    borrowRequestRepository.save(r);
  }
}
