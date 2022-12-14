package com.course.course.resources;

import com.course.course.entities.Product;
import com.course.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Fala que essa classe é um recurso web que é implementado por um controlador Rest
@RequestMapping(value = "/products") // Dá nome ao recurso, argumento é o caminho do recurso
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping // Diz que esse é um método que corresponde ao método get do Http
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
