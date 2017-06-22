package com.test.boot.Model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Роман on 22.06.2017.
 */
@Entity
@Table(name = "role", schema = "mydbtest", catalog = "")
public class RoleEntity implements Serializable  {
    private long id;
    private String roleNames;
    private UsersEntity usersById;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
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

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id_role", nullable = false)
    public UsersEntity getUsersById() {
        return usersById;
    }

    public void setUsersById(UsersEntity usersById) {
        this.usersById = usersById;
    }
}
