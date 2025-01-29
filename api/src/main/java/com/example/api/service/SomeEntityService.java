package com.example.api.service;

import com.example.api.model.SomeEntity;
import com.example.api.repository.SomeEntityRepository;
import com.example.api.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SomeEntityService {
    private final SomeEntityRepository repository;

    public SomeEntityService(SomeEntityRepository repository) {
        this.repository = repository;
    }

    public List<SomeEntity> getAllEntities() {
        return repository.findAll();
    }

    public SomeEntity getEntityById(Long id) {
        SomeEntity entity = repository.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException(id);
        }
        return entity;
    }

    public SomeEntity createEntity(SomeEntity entity) {
        return repository.save(entity);
    }

    public SomeEntity updateEntity(Long id, SomeEntity entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }
}
