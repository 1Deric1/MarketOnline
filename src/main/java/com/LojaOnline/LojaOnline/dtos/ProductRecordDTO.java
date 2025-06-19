package com.LojaOnline.LojaOnline.dtos;

import com.LojaOnline.LojaOnline.model.ProductStatus;

public record ProductRecordDTO(
        String name,
        String description,
        Double price,
        int quantity,
        ProductStatus status
) {
}
