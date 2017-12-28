package pl.ftims.pai.entities;

import javax.persistence.*;

@Entity
@Table(name = "client_order")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @OneToOne
    private Product orderedProduct;

    private int quantity;

    private boolean isFinalized;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Order() {
        orderStatus = OrderStatus.CREATED;
    }

    public long getId() {
        return id;
    }

    public Product getOrderedProduct() {
        return orderedProduct;
    }

    public void setOrderedProduct(Product orderedProduct) {
        this.orderedProduct = orderedProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isFinalized() {
        return isFinalized;
    }

    public void setFinalized(boolean finalized) {
        isFinalized = finalized;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
