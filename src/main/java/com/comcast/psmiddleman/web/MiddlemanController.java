package com.comcast.psmiddleman.web;

import com.comcast.psmiddleman.domain.MyEntity;
import com.comcast.psmiddleman.dto.Product;
import com.comcast.psmiddleman.dto.ProductNamePrice;
import com.comcast.psmiddleman.repository.MyEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class MiddlemanController {

    private final MyEntityRepository myEntityRepository;
    private final String PRODUCT_SERVICE_URL = "https://product-service-v1.apps.apbg.apcf.io";
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public List<ProductNamePrice> getAll() {
        return Arrays.stream(restTemplate.getForObject(PRODUCT_SERVICE_URL + "/all-products", Product[].class))
                .map(product -> new ProductNamePrice(product.getName(), product.getPrice()))
                .collect(Collectors.toList());
    }

    @GetMapping("/closest-to/{price}")
    public List<ProductNamePrice> getClosest(@PathVariable Double price) {
        return Arrays.stream(restTemplate.getForObject(PRODUCT_SERVICE_URL + "/all-products", Product[].class))
                .sorted((o1, o2) -> (int) (Math.abs(price - o1.getPrice()) - Math.abs(price - o2.getPrice())))
                .limit(3)
                .map(product -> new ProductNamePrice(product.getName(), product.getPrice()))
                .collect(Collectors.toList());
    }

    @GetMapping("/my-entities")
    public List<MyEntity> getAllEntities() {
        return myEntityRepository.findAll();
    }
}
