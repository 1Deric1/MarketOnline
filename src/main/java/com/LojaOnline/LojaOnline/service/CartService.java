package com.LojaOnline.LojaOnline.service;

import com.LojaOnline.LojaOnline.Handler.CartException;
import com.LojaOnline.LojaOnline.model.CartModel;
import com.LojaOnline.LojaOnline.model.ProductModel;
import com.LojaOnline.LojaOnline.repository.CartItemRepository;
import com.LojaOnline.LojaOnline.repository.CartRepository;
import com.LojaOnline.LojaOnline.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    public CartModel findById(UUID id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Transactional
    public CartModel createCart(CartModel cart) {
        if (cart.getItems() != null) {
            for (var item : cart.getItems()) {
                // Busca o produto existente no banco
                UUID productId = item.getProduct().getId();
                ProductModel existingProduct = productRepository.findById(productId)
                        .orElseThrow(() -> new CartException("Produto não encontrado: " + productId));
                item.setProduct(existingProduct);

                // Define o cart no item
                item.setCart(cart);
            }
        }
        return cartRepository.save(cart);
    }

}
