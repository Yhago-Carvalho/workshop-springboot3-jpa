package com.course.course.resources;

import com.course.course.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Fala que essa classe é um recurso web que é implementado por um controlador Rest
@RequestMapping(value = "/users") // Dá nome ao recurso, argumento é o caminho do recurso
public class UserResource {

    @GetMapping // Diz que esse é um método que corresponde ao método get do Http
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Yhago", "yhago@gmail.com", "99999999", "12345");
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }
}
