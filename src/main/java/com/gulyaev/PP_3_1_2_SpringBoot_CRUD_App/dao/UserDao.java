package com.gulyaev.PP_3_1_2_SpringBoot_CRUD_App.dao;


import com.gulyaev.PP_3_1_2_SpringBoot_CRUD_App.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {


    List<User> withdrawAllUsers();

    void saveUser(User user);

    Optional<User> findByUserId(Long id);

    void updateUser(User user);

    void deleteByUser(Long id);


}
