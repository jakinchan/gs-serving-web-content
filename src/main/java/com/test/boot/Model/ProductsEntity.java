package com.test.boot.Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Роман on 22.06.2017.
 */
@Entity
@Table(name = "products", schema = "mydbtest")
public class ProductsEntity extends AbstractEntity{
    private int count;
    private String description;
    private String name;
    private long price;
    private Collection<BasketProductsEntity> basketProductsById;


    @Basic
    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (id != that.id) return false;
        if (count != that.count) return false;
        if (price != that.price) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + count;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (price ^ (price >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "productsByIdProduct")
    public Collection<BasketProductsEntity> getBasketProductsById() {
        return basketProductsById;
    }

    public void setBasketProductsById(Collection<BasketProductsEntity> basketProductsById) {
        this.basketProductsById = basketProductsById;
    }

    @Override
    public String toString() {
        return "ProductsEntity{" +
                "count=" + count +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
