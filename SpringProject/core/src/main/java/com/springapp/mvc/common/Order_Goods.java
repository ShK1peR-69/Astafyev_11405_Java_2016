package com.springapp.mvc.common;

import javax.persistence.*;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Entity
@Table(name="Order_Goods")
public class Order_Goods {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "count")
    private int count;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "good_id")
    private Goods goods;

    public Order_Goods() {
    }

    public Order_Goods(int count) {
        this.count = count;
    }

    public Order_Goods(int count, Goods goods, Order order) {
        this.count = count;
        this.goods = goods;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Order_Goods{" +
                "id=" + id +
                ", count=" + count +
                ", order=" + order +
                ", goods=" + goods +
                '}';
    }
}
