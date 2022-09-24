package com.company.ecommerceApi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nane;

    private String surname;

    private String number;

    public Owner(String nane, String surname, String number) {
        this.nane = nane;
        this.surname = surname;
        this.number = number;
    }
}
