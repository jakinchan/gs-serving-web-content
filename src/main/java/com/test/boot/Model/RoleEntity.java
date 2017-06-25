package com.test.boot.Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Роман on 22.06.2017.
 */
@Entity
@Table(name = "role")
public class RoleEntity extends AbstractEntity{

    private String roleNames;
    private Collection<UsersEntity> usersById;

    @Basic
    @Column(name = "role_names", nullable = false, length = 45)
    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (roleNames != null ? !roleNames.equals(that.roleNames) : that.roleNames != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (roleNames != null ? roleNames.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByIdRole")
    public Collection<UsersEntity> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UsersEntity> usersById) {
        this.usersById = usersById;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "roleNames='" + roleNames + '\'' +
                ", id=" + id +
                '}';
    }
}
