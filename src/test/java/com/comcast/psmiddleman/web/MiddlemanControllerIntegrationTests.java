package com.comcast.psmiddleman.web;

import com.comcast.psmiddleman.dto.ProductNamePrice;
import com.comcast.psmiddleman.service.MiddlemanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MiddlemanController.class)
public class MiddlemanControllerIntegrationTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MiddlemanService middlemanService;

    @Test
    public void getAllTest() throws Exception {
        List<ProductNamePrice> productNamePriceList = new ArrayList<ProductNamePrice>() {{
            add(new ProductNamePrice("product1", 1.99));
        }};

        given(this.middlemanService.getAll()).willReturn(productNamePriceList);

        mvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\"product1\",\"price\":1.99}]"));
    }

    @Test
    public void getClosestToTest() throws Exception {
        List<ProductNamePrice> productNamePriceList = new ArrayList<ProductNamePrice>() {{
            add(new ProductNamePrice("product1", 1.99));
            add(new ProductNamePrice("product2", 2.99));
            add(new ProductNamePrice("product3", 3.99));
        }};

        given(this.middlemanService.getAll()).willReturn(productNamePriceList);

        mvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\"product1\",\"price\":1.99},{\"name\":\"product2\",\"price\":2.99},{\"name\":\"product3\",\"price\":3.99}]"));
    }
}
