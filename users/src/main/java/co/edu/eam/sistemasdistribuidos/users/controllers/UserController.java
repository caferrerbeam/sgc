package co.edu.eam.sistemasdistribuidos.users.controllers;

import co.edu.eam.sistemasdistribuidos.users.models.User;
import co.edu.eam.sistemasdistribuidos.users.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {

        @Autowired
        private UserService UserService;

        @GetMapping("/{id}")
        public User buscar(@PathVariable Long id){
            return UserService.buscar(id);
        }

}
