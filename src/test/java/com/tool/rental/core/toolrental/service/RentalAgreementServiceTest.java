package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.RentalAgreementDTO;
import com.tool.rental.core.toolrental.entity.RentalAgreement;
import com.tool.rental.core.toolrental.repository.RentalAgreementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RentalAgreementServiceTest {
    @Mock
    private RentalAgreementRepository rentalAgreementRepository;

    @InjectMocks
    private RentalAgreementServiceImpl rentalAgreementServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateRentalAgreement() {
        // Create a sample RentalAgreementDto
        RentalAgreementDTO rentalAgreementDto = new RentalAgreementDTO();
        rentalAgreementDto.setToolCode("JAKR");
        rentalAgreementDto.setRentalDays(5);

        RentalAgreement savedRentalAgreement = new RentalAgreement();
        when(rentalAgreementRepository.save(any(RentalAgreement.class))).thenReturn(savedRentalAgreement);

        RentalAgreement createdRentalAgreement = rentalAgreementServiceImpl.createRentalAgreement(rentalAgreementDto);

        assertNotNull(createdRentalAgreement);
    }

    @Test
    public void testGetRentalAgreementById() {
        RentalAgreement rentalAgreement = new RentalAgreement();
        when(rentalAgreementRepository.findById(1L)).thenReturn(Optional.of(rentalAgreement));

        RentalAgreement retrievedRentalAgreement = rentalAgreementServiceImpl.getRentalAgreementById(1L);

        assertNotNull(retrievedRentalAgreement);
    }
}
