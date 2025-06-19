package com.LojaOnline.LojaOnline.controller;

import com.LojaOnline.LojaOnline.dtos.ProductRecordDTO;
import com.LojaOnline.LojaOnline.model.ProductModel;
import com.LojaOnline.LojaOnline.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/productsStore/store")
public class ProductController implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductModel> saveProduct(@RequestBody ProductRecordDTO productRecordDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productRecordDTO));
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable UUID id){
        productService.delete(id);
    }
}
