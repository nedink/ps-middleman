package com.comcast.psmiddleman.service;

import com.comcast.psmiddleman.dto.ProductNamePrice;

import java.util.List;

public interface MiddlemanService {
    List<ProductNamePrice> getAll();
    List<ProductNamePrice> getClosestTo(Double price);
}
