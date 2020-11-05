package co.edu.eam.sistemasdistribuidos.sgc.request.services;

import co.edu.eam.sistemasdistribuidos.sgc.core.models.BorrowRequest;
import co.edu.eam.sistemasdistribuidos.sgc.core.repositories.BorrowRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowRequestService {

  @Autowired
  private BorrowRequestRepository borrowRequestRepository;
  /**
   * metodo para enviar a estudio a traves de la cola el credito.
   * @param borrow
   */
  public void studyBorrow(BorrowRequest borrow) {

  }

  public BorrowRequest find(Long id){
    boolean request = borrowRequestRepository.existsById(id);
    if(!request)
      throw new RuntimeException("No existe una solicitud con ID: "+id);

    return borrowRequestRepository.findById(id).get();
  }

}
