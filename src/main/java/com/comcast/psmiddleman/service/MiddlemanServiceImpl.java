package com.comcast.psmiddleman.service;

import com.comcast.psmiddleman.dto.Product;
import com.comcast.psmiddleman.dto.ProductNamePrice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MiddlemanServiceImpl implements MiddlemanService {

    private final RestTemplate restTemplate;

    @Value("${PRODUCT_SERVICE_URL:}") // pull in from application.properties (or cloud environment variable if set)
    private String PRODUCT_SERVICE_URL;

    public MiddlemanServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ProductNamePrice> getAll() {
        return Arrays.stream(restTemplate.getForObject(PRODUCT_SERVICE_URL + "/all-products", Product[].class))
                .map(product -> new ProductNamePrice(product.getName(), product.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductNamePrice> getClosestTo(Double price) {
        return Arrays.stream(restTemplate.getForObject(PRODUCT_SERVICE_URL + "/all-products", Product[].class))
                .sorted((o1, o2) -> (int) (Math.abs(price - o1.getPrice()) - Math.abs(price - o2.getPrice())))
                .limit(3)
                .map(product -> new ProductNamePrice(product.getName(), product.getPrice()))
                .collect(Collectors.toList());
    }
}
