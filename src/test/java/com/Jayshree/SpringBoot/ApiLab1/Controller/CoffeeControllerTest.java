package com.Jayshree.SpringBoot.ApiLab1.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class CoffeeControllerTest {

    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testGetCoffee() throws Exception{
        String expectedString = "I like coffee!";

        mockMvcController.perform(MockMvcRequestBuilders.get("/coffeeLover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedString));
    }
    @Test
    public void testGetCoffeeWithoutRequestParam() throws Exception {
        String expectedValue = "latte";
        this.mockMvcController.perform(MockMvcRequestBuilders.get("/coffee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));
    }

    @Test
    public void testGetCoffeeWithRequestParam() throws Exception{
        String expectedValue = "cappuccino";
        this.mockMvcController.perform(MockMvcRequestBuilders.get("/coffee").param("name", "cappuccino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));

    }

}
