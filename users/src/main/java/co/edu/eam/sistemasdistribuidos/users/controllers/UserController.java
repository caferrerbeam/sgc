package co.edu.eam.sistemasdistribuidos.users.controllers;

import co.edu.eam.sistemasdistribuidos.users.models.User;
import co.edu.eam.sistemasdistribuidos.users.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@RequestBody User user) throws JsonProcessingException {
        userService.create(user);
    }

    @GetMapping("/{id}")
     public User buscar(@PathVariable Long id){
         return UserService.buscar(id);
     }
}
