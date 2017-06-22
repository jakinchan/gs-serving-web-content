package com.test.boot.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Роман on 22.06.2017.
 */
@MappedSuperclass
public abstract class AbstractEntity {
    protected long id;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public abstract boolean equals(Object o);


    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}
