package co.edu.eam.sistemasdistribuidos.users.services;

import co.edu.eam.sistemasdistribuidos.users.models.User;
import co.edu.eam.sistemasdistribuidos.users.producers.UsersQueueProducer;
import co.edu.eam.sistemasdistribuidos.users.repositories.USerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private USerRepository uSerRepository;

    @Autowired
    private UsersQueueProducer usersQueueProducer;

    public void create(User user) throws JsonProcessingException {
        uSerRepository.save(user);
        usersQueueProducer.notifyUserCreation(user);
    }

    //estudiante 4   buscar por id
    public User buscar(long id) {
        //verifico si existe el id
        boolean userExist = USerRepository.existsById(id);
        if (!userExist) throw  new RuntimeException("no existe el usuario");
        //busco los datos y con el get lo obtengo
        return USerRepository.findById(id).get();
    }

}
