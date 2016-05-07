package com.springapp.mvc.common;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
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
    private double size;

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

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private Category category;

    public Goods() {
    }

    public Goods(String name, BigDecimal price, String brand, Integer popular, String describe, double size, String image, String sport, String age) {
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getCategoryID() {
        return category.getId();
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

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", popular=" + popular +
                ", describe='" + describe + '\'' +
                ", size=" + size +
                ", image='" + image + '\'' +
                ", sport='" + sport + '\'' +
                ", age='" + age + '\'' +
                ", cart=" + cart +
                ", category=" + category +
                '}';
    }
}
