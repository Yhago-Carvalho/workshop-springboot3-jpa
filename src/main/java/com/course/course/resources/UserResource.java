package com.course.course.resources;

import com.course.course.entities.User;
import com.course.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Fala que essa classe é um recurso web que é implementado por um controlador Rest
@RequestMapping(value = "/users") // Dá nome ao recurso, argumento é o caminho do recurso
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping // Diz que esse é um método que corresponde ao método get do Http
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
