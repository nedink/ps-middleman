package com.comcast.psmiddleman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductNamePrice {
    private String name;
    private Double price;
}
