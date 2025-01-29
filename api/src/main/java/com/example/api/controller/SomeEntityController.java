package com.example.api.controller;

import com.example.api.model.SomeEntity;
import com.example.api.service.SomeEntityService;
import com.example.api.exception.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/entities")
public class SomeEntityController {
    private final SomeEntityService service;

    public SomeEntityController(SomeEntityService service) {
        this.service = service;
    }

    @GetMapping
    public List<SomeEntity> getAllEntities() {
        return service.getAllEntities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SomeEntity> getEntityById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getEntityById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public SomeEntity createEntity(@RequestBody SomeEntity entity) {
        return service.createEntity(entity);
    }

    @PutMapping("/{id}")
    public SomeEntity updateEntity(@PathVariable Long id, @RequestBody SomeEntity entity) {
        return service.updateEntity(id, entity);
    }

    @DeleteMapping("/{id}")
    public void deleteEntity(@PathVariable Long id) {
        service.deleteEntity(id);
    }
}
