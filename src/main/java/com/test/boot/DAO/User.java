package com.test.boot.DAO;

import com.test.boot.Model.UsersEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Роман on 22.06.2017.
 */
public interface User extends CrudRepository<UsersEntity, Long> {
    //public UsersEntity selectByNameAndAndPassword(String name, String password);
    public UsersEntity findByNameAndPassword(String name, String password);
}
