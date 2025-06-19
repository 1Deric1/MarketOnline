package com.LojaOnline.LojaOnline.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_cart")
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItemModel> items;

    private boolean finalized;

    @Transient
    public double getTotalPrice() {
        return items.stream().mapToDouble(CartItemModel::getTotalPrice).sum();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<CartItemModel> getItems() {
        return items;
    }

    public void setItems(List<CartItemModel> items) {
        this.items = items;
    }

    public boolean isFinalized() {
        return finalized;
    }

    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }
}
