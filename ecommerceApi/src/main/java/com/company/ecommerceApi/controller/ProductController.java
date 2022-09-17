package com.company.ecommerceApi.controller;

import com.company.ecommerceApi.entity.ImageModel;
import com.company.ecommerceApi.entity.Product;
import com.company.ecommerceApi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@CrossOrigin()
public class ProductController {


    private final ProductService productService;

    @PostMapping(value = {"/add"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addNewProduct(@RequestPart("product") Product product,
                                 @RequestPart("image") MultipartFile[] file){
        try {
            Set<ImageModel> images = loadImage(file);
            product.setProductImages(images);
            productService.addProduct(product);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return product;
    }


    private Set<ImageModel> loadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageList = new HashSet<>();

        for(MultipartFile file: multipartFiles){
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageList.add(imageModel);
        }
        return imageList;
    }
}
