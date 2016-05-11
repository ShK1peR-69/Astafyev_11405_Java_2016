package com.springapp.mvc.common;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Entity
@Table(name = "Goods")
public class Goods {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "brand")
    private String brand;

    @Column(name = "popular")
    private Integer popular;

    @Column(name = "describe")
    private String describe;

    @Column(name = "size")
    private String size;

    @Column(name = "image")
    private String image;

    @Column(name = "sport")
    private String sport;

    @Column(name = "age")
    private String age;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "goods")
    private List<Cart> cart;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="goods")
    private List<Comments> comments;

    public Goods() {
    }

    public Goods(String name, BigDecimal price, String brand, Integer popular, String describe, String size, String image, String sport, String age) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.popular = popular;
        this.describe = describe;
        this.size = size;
        this.image = image;
        this.sport = sport;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


    public void setPopular(Integer popular) {
        this.popular = popular;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getPopular() {
        return popular;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", popular=" + popular +
                ", describe='" + describe + '\'' +
                ", size='" + size + '\'' +
                ", image='" + image + '\'' +
                ", sport='" + sport + '\'' +
                ", age='" + age + '\'' +
                ", cart=" + cart +
                ", comments=" + comments +
                '}';
    }
}
