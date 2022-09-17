package com.company.ecommerceApi.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    private String productName;

    private String productDescription;

    private double productPrice;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "product_images",
        joinColumns = {
            @JoinColumn(name = "product_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "image_id")
        }
    )
    private Set<ImageModel> productImages;
}
