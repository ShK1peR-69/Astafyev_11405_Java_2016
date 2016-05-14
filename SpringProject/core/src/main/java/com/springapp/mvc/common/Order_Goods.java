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
    private Order order_id;

    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "goods")
    private Goods goods;

    public Order_Goods() {
    }

    public Order_Goods(int count) {
        this.count = count;
    }

    public Order_Goods(int count, Goods goods, Order order_id) {
        this.count = count;
        this.goods = goods;
        this.order_id = order_id;
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

    public Order getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Order order_id) {
        this.order_id = order_id;
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
                ", order_id=" + order_id +
                ", goods=" + goods +
                '}';
    }
}
