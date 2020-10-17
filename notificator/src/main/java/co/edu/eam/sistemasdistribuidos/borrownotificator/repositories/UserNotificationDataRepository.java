package co.edu.eam.sistemasdistribuidos.borrownotificator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.eam.sistemasdistribuidos.borrownotificator.models.UserNotificationData;

@Repository
public interface UserNotificationDataRepository extends JpaRepository<UserNotificationData, Long> {
}
