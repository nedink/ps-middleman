package com.comcast.psmiddleman;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MiddlemanController {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class MyObject {
        private String name;
        private String desc;
    }



    @GetMapping
    public MyObject getHello() {
        MyObject myObject = MyObject.builder()
                .name("name")
                .desc("here is a description")
                .build();

        return myObject;
    }


    @GetMapping("/all-products")
    public List<ProductPriceName> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        List<Product> products = Arrays.asList(restTemplate.getForObject("https://product-service-v1.apps.apbg.apcf.io/all-products", Product[].class)) ;
        List<ProductPriceName> result =  products.stream()
                .sorted((o1, o2) -> (int) (Math.abs(40 - o1.price) - Math.abs(40 - o2.price)))
                .limit(3)
                .map(product -> new ProductPriceName(product.name, product.price))
                .collect(Collectors.toList());
        return result;
    }
}
