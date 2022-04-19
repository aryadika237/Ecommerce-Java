package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepo categoryRepo;

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category dose not exists")HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(productDto.optmalcategory.get());
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been added")HttpStatus.CREATED);
    }

    @GetMapping

    @PostMapping
}
