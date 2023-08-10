package com.tool.rental.core.toolrental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tool.rental.core.toolrental.entity.RentalAgreement;
import com.tool.rental.core.toolrental.service.RentalAgreementService;
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

@WebMvcTest(RentalAgreementController.class)
public class RentalAgreementControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RentalAgreementService rentalAgreementService;

    @Test
    public void testCreateRentalAgreement() throws Exception {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setToolCode("JAKR");
        rentalAgreement.setRentalDays(5);

        doReturn(rentalAgreement).when(rentalAgreementService).createRentalAgreement(any());

        mockMvc.perform(post("/rentalAgreement")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(rentalAgreement)))
                .andExpect(status().isCreated());
    }
}
