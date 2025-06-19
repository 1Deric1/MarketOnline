package com.LojaOnline.LojaOnline.repository;

import com.LojaOnline.LojaOnline.model.CartItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartItemRepository extends JpaRepository <CartItemModel,UUID>{
}
