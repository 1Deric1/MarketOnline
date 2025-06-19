package com.LojaOnline.LojaOnline.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_cart_item")
public class CartItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne( cascade = CascadeType.ALL)
    private ProductModel product;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private CartModel cart;

    private double unitPrice;

    private int quantity;

    @Transient
    public double getTotalPrice() {
        return unitPrice * quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setCart(CartModel cart) {
        this.cart = cart;
    }

}
