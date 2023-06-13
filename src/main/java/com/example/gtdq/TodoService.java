package com.example.gtdq;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TodoService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public Todo create(String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);
        entityManager.persist(todo);

        return todo;
    }

    public List<Todo> getAll() {
        return entityManager.createQuery("SELECT t FROM Todo t", Todo.class)
                .getResultList();
    }
}
