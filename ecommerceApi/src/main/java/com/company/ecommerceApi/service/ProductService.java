package com.company.ecommerceApi.service;

import com.company.ecommerceApi.entity.Product;
import com.company.ecommerceApi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(Product product){
       return productRepository.save(product);
    }
}
