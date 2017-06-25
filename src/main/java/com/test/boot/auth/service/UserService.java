package com.test.boot.auth.service;

import com.test.boot.Model.UsersEntity;

public interface UserService {
    void save(UsersEntity user);

    UsersEntity findByName(String name);
}
