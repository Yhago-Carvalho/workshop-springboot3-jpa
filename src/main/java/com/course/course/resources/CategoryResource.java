package com.course.course.resources;

import com.course.course.entities.Category;
import com.course.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Fala que essa classe é um recurso web que é implementado por um controlador Rest
@RequestMapping(value = "/categories") // Dá nome ao recurso, argumento é o caminho do recurso
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping // Diz que esse é um método que corresponde ao método get do Http
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = categoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
