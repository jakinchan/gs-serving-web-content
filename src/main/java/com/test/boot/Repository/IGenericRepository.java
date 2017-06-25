package com.test.boot.Repository;

import com.test.boot.Model.AbstractEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Роман on 22.06.2017.
 */
public interface IGenericRepository<T extends AbstractEntity> extends CrudRepository<T, Long> {
}
