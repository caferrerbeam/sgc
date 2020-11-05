package co.edu.eam.sistemasdistribuidos.users.repositories;

import co.edu.eam.sistemasdistribuidos.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface USerRepository  extends JpaRepository<User, Long> {

}
