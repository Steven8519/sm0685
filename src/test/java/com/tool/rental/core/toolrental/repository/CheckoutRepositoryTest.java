package com.tool.rental.core.toolrental.repository;

import com.tool.rental.core.toolrental.entity.Checkout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@DataJpaTest
public class CheckoutRepositoryTest {
    @MockBean
    private CheckoutRepository checkoutRepository;

    @BeforeEach
    public void setUp() {
        Checkout checkout = new Checkout();
        checkout.setId(1L);
        when(checkoutRepository.findById(1L)).thenReturn(java.util.Optional.of(checkout));
    }

    @Test
    public void testFindById() {
        Checkout retrievedCheckout = checkoutRepository.findById(1L).orElse(null);

        assertNotNull(retrievedCheckout);
        assertEquals(1L, retrievedCheckout.getId());
    }
}
