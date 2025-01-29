package com.example.api.service;

import com.example.api.model.SomeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SomeEntityServiceTest {
    @Autowired
    private SomeEntityService service;

    @Test
    void testCreateReadUpdateDelete() {
        // Remove existing entities
        List<SomeEntity> existing = service.getAllEntities();
        for (SomeEntity e : existing) {
            service.deleteEntity(e.getId());
        }

        // Create
        SomeEntity newEntity = new SomeEntity();
        newEntity.setSomeField("test");
        newEntity = service.createEntity(newEntity);

        // Read
        SomeEntity fetched = service.getEntityById(newEntity.getId());
        assertEquals("test", fetched.getSomeField());

        // Update
        fetched.setSomeField("updated");
        service.updateEntity(fetched.getId(), fetched);
        SomeEntity updated = service.getEntityById(fetched.getId());
        assertEquals("updated", updated.getSomeField());
    }
}