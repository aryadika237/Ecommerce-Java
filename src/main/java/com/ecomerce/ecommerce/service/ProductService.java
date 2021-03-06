package com.ecomerce.ecommerce.service;

import com.ecomerce.ecommerce.dto.ProductDto;
import com.ecomerce.ecommerce.model.Category;
import com.ecomerce.ecommerce.model.Product;
import com.ecomerce.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setNamaProduct(productDto.getNamaProduct());
        product.setDesc(productDto.getDesc());
        product.setImgUrl(productDto.getImgUrl());
        product.setHarga(productDto.getHarga());
        product.setCategory(category);
        productRepository.save(product);
    }


    public ProductDto getProductDto(Product product) {
        Product productDto = new Product();
        productDto.setId(product.getId());
        productDto.setNamaProduct(product.getNamaProduct());
        productDto.setDesc(product.getDesc());
        productDto.setImgUrl(product.getImgUrl());
        productDto.setHarga(product.getHarga());
        productDto.setCategory_id(product.getCategory().getId());
        return productDto;

    }

    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product: allProducts) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    public void updateProduct(ProductDto productDto, int productId) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new Exception("product not present!");
        }
        Product product = optionalProduct.get();
        product.setNamaProduct(productDto.getNamaProduct());
        product.setDesc(productDto.getDesc());
        product.setImgUrl(productDto.getImgUrl());
        product.setHarga(productDto.getHarga());
        productRepository.save(product);
    }
}
