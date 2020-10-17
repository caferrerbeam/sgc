package co.edu.eam.sistemasdistribuidos.sgc.core.repositories;

import co.edu.eam.sistemasdistribuidos.sgc.core.models.BorrowRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRequestRepository extends JpaRepository<BorrowRequest, Integer> {
}
