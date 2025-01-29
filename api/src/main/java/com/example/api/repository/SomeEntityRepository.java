package com.example.api.repository;

import com.example.api.model.SomeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SomeEntityRepository {
    private final SessionFactory sessionFactory;

    public SomeEntityRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<SomeEntity> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from SomeEntity", SomeEntity.class).list();
        }
    }

    public SomeEntity findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(SomeEntity.class, id);
        }
    }

    public SomeEntity save(SomeEntity entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            if (entity.getId() == null) {
                session.persist(entity);
            } else {
                entity = session.merge(entity);
            }
            tx.commit();
            return entity;
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            SomeEntity entity = session.get(SomeEntity.class, id);
            if (entity != null) {
                session.remove(entity);
            }
            tx.commit();
        }
    }
}
