package com.tool.rental.core.toolrental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tool.rental.core.toolrental.entity.Checkout;
import com.tool.rental.core.toolrental.service.CheckoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CheckoutController.class)
public class CheckoutControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CheckoutService checkoutService;

    @Test
    public void testCreateCheckout() throws Exception {
        Checkout checkout = new Checkout();
        checkout.setRentalDayCount(5);
        checkout.setDiscountPercent(10);

        doReturn(checkout).when(checkoutService).createCheckout(any());

        mockMvc.perform(post("/checkout")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(checkout)))
                .andExpect(status().isCreated());
    }
}
