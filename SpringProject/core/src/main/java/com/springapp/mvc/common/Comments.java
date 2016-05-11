package com.springapp.mvc.common;

import javax.persistence.*;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Entity
@Table(name="Comments")
public class Comments {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "message")
    private String message;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "users")
    private Users users;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "goods")
    private Goods goods;

    public Comments() {
    }

    public Comments(String message, Users users, Goods goods) {
        this.message = message;
        this.users = users;
        this.goods = goods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        return "Comments{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", users=" + users +
                ", goods=" + goods +
                '}';
    }
}