package com.tool.rental.core.toolrental.repository;

import com.tool.rental.core.toolrental.entity.RentalAgreement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@DataJpaTest
public class RentalAgreementRepositoryTest {
    @MockBean
    private RentalAgreementRepository rentalAgreementRepository;

    @BeforeEach
    public void setUp() {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setId(1L);
        when(rentalAgreementRepository.findById(1L)).thenReturn(java.util.Optional.of(rentalAgreement));
    }

    @Test
    public void testFindById() {
        RentalAgreement retrievedRentalAgreement = rentalAgreementRepository.findById(1L).orElse(null);

        assertNotNull(retrievedRentalAgreement);
        assertEquals(1L, retrievedRentalAgreement.getId());
    }
}
