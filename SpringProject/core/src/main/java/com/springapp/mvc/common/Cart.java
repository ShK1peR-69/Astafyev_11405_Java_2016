package com.springapp.mvc.common;

import javax.persistence.*;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Entity
@Table(name="Cart")
public class Cart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "count")
    private int count;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.EAGER)
    @JoinColumn(name = "users")
    private Users users;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.EAGER)
    @JoinColumn(name = "goods")
    private Goods goods;

    public Cart() {
    }

    public Cart(int count, Goods goods, Users users) {
        this.count = count;
        this.goods = goods;
        this.users = users;
    }

    public Cart(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", count=" + count +
                ", users=" + users +
                ", goods=" + goods +
                '}';
    }
}
