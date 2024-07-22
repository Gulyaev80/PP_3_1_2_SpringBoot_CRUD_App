package com.gulyaev.PP_3_1_2_SpringBoot_CRUD_App.dao;

import com.gulyaev.PP_3_1_2_SpringBoot_CRUD_App.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override

    public List<User> withdrawAllUsers() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public Optional<User> findByUserId(Long id) {
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteByUser(Long id) {
        Optional<User> userById = findByUserId(id);
        userById.ifPresent(user -> entityManager.remove(user));
    }
}
