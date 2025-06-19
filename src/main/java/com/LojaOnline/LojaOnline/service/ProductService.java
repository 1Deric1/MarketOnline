package com.LojaOnline.LojaOnline.service;

import com.LojaOnline.LojaOnline.dtos.ProductRecordDTO;
import com.LojaOnline.LojaOnline.model.ProductModel;
import com.LojaOnline.LojaOnline.repository.CartItemRepository;
import com.LojaOnline.LojaOnline.repository.CartRepository;
import com.LojaOnline.LojaOnline.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    public ProductService(CartRepository cartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }
    public List<ProductModel> getAllProducts(){
        return productRepository.findAll();
    }
    @Transactional
    public ProductModel save(ProductRecordDTO productRecordDTO) {
        ProductModel productModel = new ProductModel();
        productModel.setName(productRecordDTO.name());
        productModel.setDescription(productRecordDTO.description());
        productModel.setPrice(productRecordDTO.price());
        productModel.setQuantity(productRecordDTO.quantity());
        productModel.setStatus(productRecordDTO.status());

        return productRepository.save(productModel);
    }

    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

}
