package com.comcast.psmiddleman.web;

import com.comcast.psmiddleman.dto.ProductNamePrice;
import com.comcast.psmiddleman.service.MiddlemanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class MiddlemanController {

    private final MiddlemanService middlemanService;

    @GetMapping
    public List<ProductNamePrice> getAll() {
        return middlemanService.getAll();
    }

    @GetMapping("/closest-to/{price}")
    public List<ProductNamePrice> getClosestTo(@PathVariable Double price) {
        return middlemanService.getClosestTo(price);

    }
}
