package com.test.boot.DAO;

import com.test.boot.Model.UsersEntity;

/**
 * Created by Роман on 22.06.2017.
 */
public interface User extends IGenericDao<UsersEntity>{
    public UsersEntity findByNameAndPassword(String name, String password);
}
