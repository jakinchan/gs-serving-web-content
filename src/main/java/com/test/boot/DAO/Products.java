package com.test.boot.DAO;

import com.test.boot.Model.ProductsEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Роман on 22.06.2017.
 */
public interface Products extends CrudRepository<ProductsEntity, Long> {
}
