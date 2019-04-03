package com.comcast.psmiddleman.service;

import com.comcast.psmiddleman.dto.ProductNamePrice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiddlemanServiceTests {

    @Autowired
    private MiddlemanService middlemanService;

    @Test
    public void getAllTest() {
        List<ProductNamePrice> result = middlemanService.getAll();
        assertNotNull(result);
    }

    @Test
    public void getClosestToTest() {
        List<ProductNamePrice> result1 = middlemanService.getClosestTo(-1.0);
        assertNotNull(result1);
        List<ProductNamePrice> result2 = middlemanService.getClosestTo(1.0);
        assertNotNull(result2);
        List<ProductNamePrice> result3 = middlemanService.getClosestTo(1.333);
        assertNotNull(result3);
    }
}
