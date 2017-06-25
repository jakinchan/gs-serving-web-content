package com.test.boot.Repository;

import com.test.boot.Model.UsersEntity;

/**
 * Created by Роман on 22.06.2017.
 */
public interface UserRepository extends IGenericRepository<UsersEntity> {
    public UsersEntity findByUsernameAndPassword(String name, String password);
    public UsersEntity findByUsername(String name);
}
