package com.springapp.mvc.common;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Entity
@Table(name="Orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "time")
    private Date time;

    @Column(name = "total_sum")
    private BigDecimal total_sum;

    @Column(name = "total_count")
    private int total_count;

    @Column(name = "status")
    private String status;

    @Column(name = "pay_type")
    private String pay_type;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "users")
    private Users users;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "address")
    private Address address;

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="order")
    private List<Order_Goods> order_goods;


    public Order() {
    }

    public Order(Date time, BigDecimal total_sum, int total_count, String status, String pay_type, Users users, Address address) {
        this.time = time;
        this.total_sum = total_sum;
        this.total_count = total_count;
        this.status = status;
        this.pay_type = pay_type;
        this.users = users;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public BigDecimal getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(BigDecimal total_sum) {
        this.total_sum = total_sum;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order_Goods> getOrder_goods() {
        return order_goods;
    }

    public void setOrder_goods(List<Order_Goods> order_goods) {
        this.order_goods = order_goods;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", time=" + time +
                ", total_sum=" + total_sum +
                ", total_count=" + total_count +
                ", status='" + status + '\'' +
                ", pay_type='" + pay_type + '\'' +
                ", users=" + users +
                ", address=" + address +
                '}';
    }
}
