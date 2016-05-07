package com.springapp.mvc.common;

import javax.persistence.*;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Entity
@Table(name="Users")
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;


    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "checking")
    private Boolean checking;

    @Column(name = "key")
    private String key;

    @Column(name = "role")
    private String role;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="users")
    private List<Address> address;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="users")
    private List<Cart> cart;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="users")
    private List<Order> order;

    public Users() {
    }

    public Users(String name, String username, String email, String password, Boolean checking, String key, String role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.checking = checking;
        this.key = key;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getChecking() {
        return checking;
    }

    public void setChecking(Boolean checking) {
        this.checking = checking;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", checking=" + checking +
                ", key='" + key + '\'' +
                ", role='" + role + '\'' +
                ", address=" + address +
                ", cart=" + cart +
                ", order=" + order +
                '}';
    }
}
