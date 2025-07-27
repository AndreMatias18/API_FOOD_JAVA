package dev.javamatias.aprendizado.controller;

import dev.javamatias.aprendizado.model.ModelAprendizado;
import dev.javamatias.aprendizado.service.ServiceAprendizado;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")

public class ControllerAprendizado {

    private final ServiceAprendizado serviceAprendizado;

    public ControllerAprendizado(ServiceAprendizado serviceAprendizado) {
        this.serviceAprendizado = serviceAprendizado;
    }

    @GetMapping
    public List<ModelAprendizado> getAll(){return serviceAprendizado.getAll();}

    @PostMapping
    public ModelAprendizado create(@RequestBody ModelAprendizado food) {return serviceAprendizado.save(food);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {serviceAprendizado.delete(id);}

    @PutMapping("/{id}")
    public ResponseEntity<ModelAprendizado> updateFood(@PathVariable Long id, @RequestBody ModelAprendizado newData) {
        ModelAprendizado updated = serviceAprendizado.update(id, newData);
        return ResponseEntity.ok(updated);
    }



}
