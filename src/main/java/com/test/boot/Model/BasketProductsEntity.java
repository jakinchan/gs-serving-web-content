package com.test.boot.Model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Роман on 22.06.2017.
 */
@Entity
@Table(name = "basket_products", schema = "mydbtest", catalog = "")
public class BasketProductsEntity {
    private long id;
    private int countProduct;
    private Date date;
    private long idOrder;
    private ProductsEntity productsByIdProduct;
    private UsersEntity usersByIdBuyer;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "count_product", nullable = false)
    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "id_order", nullable = false)
    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasketProductsEntity that = (BasketProductsEntity) o;

        if (id != that.id) return false;
        if (countProduct != that.countProduct) return false;
        if (idOrder != that.idOrder) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + countProduct;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) (idOrder ^ (idOrder >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    public ProductsEntity getProductsByIdProduct() {
        return productsByIdProduct;
    }

    public void setProductsByIdProduct(ProductsEntity productsByIdProduct) {
        this.productsByIdProduct = productsByIdProduct;
    }

    @ManyToOne
    @JoinColumn(name = "id_buyer", referencedColumnName = "id", nullable = false)
    public UsersEntity getUsersByIdBuyer() {
        return usersByIdBuyer;
    }

    public void setUsersByIdBuyer(UsersEntity usersByIdBuyer) {
        this.usersByIdBuyer = usersByIdBuyer;
    }


}
