package com.comcast.psmiddleman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    Integer id;
    String name;
    String description;
    String image;
    Double price;
}
