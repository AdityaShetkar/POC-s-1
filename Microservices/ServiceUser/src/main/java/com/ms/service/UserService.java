package com.ms.service;

import com.ms.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    User getById(String userId);

    User save(User user);

    void delete(String userId);

    User update(User user, String userId);

}
