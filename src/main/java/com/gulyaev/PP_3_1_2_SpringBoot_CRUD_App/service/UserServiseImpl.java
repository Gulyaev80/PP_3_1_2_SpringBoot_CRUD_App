package com.gulyaev.PP_3_1_2_SpringBoot_CRUD_App.service;

import com.gulyaev.PP_3_1_2_SpringBoot_CRUD_App.dao.UserDao;
import com.gulyaev.PP_3_1_2_SpringBoot_CRUD_App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service

public class UserServiseImpl implements UserService {

    private final UserDao userDao;


    @Autowired
    public UserServiseImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> withdrawAllUsers() {
        return userDao.withdrawAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByUserId(Long id) {
        return userDao.findByUserId(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteByUser(Long id) {
        userDao.deleteByUser(id);
    }
}
