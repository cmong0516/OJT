package com.example.demo.user;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public Long save(User user) {
        em.persist(user);
        return user.getId();
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public User findByUserId(String userId) {
        return em.find(User.class, userId);
    }

    public void deleteUser(String userId) {

    }
}
