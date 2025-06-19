package com.LojaOnline.LojaOnline.controller;

import com.LojaOnline.LojaOnline.dtos.ProductRecordDTO;
import com.LojaOnline.LojaOnline.model.CartModel;
import com.LojaOnline.LojaOnline.model.ProductModel;
import com.LojaOnline.LojaOnline.service.CartService;
import com.LojaOnline.LojaOnline.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carts")
public class CartController implements Serializable {

    private static final long serialVersionUID = 1L;
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartModel> getCartById(@PathVariable UUID id){
        CartModel cart = cartService.findById(id);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cart);
    }

    @PostMapping
    public ResponseEntity<CartModel> createCart(@RequestBody CartModel cart) {
        CartModel savedCart = cartService.createCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable UUID id){
        cartService.findById(id);
    }
}
