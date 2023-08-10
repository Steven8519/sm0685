package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.CheckoutDTO;
import com.tool.rental.core.toolrental.entity.Checkout;
import com.tool.rental.core.toolrental.repository.CheckoutRepository;
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
class CheckoutServiceTest {
    @Mock
    private CheckoutRepository checkoutRepository;

    @InjectMocks
    private CheckoutServiceImpl checkoutServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCheckout() {
        CheckoutDTO checkoutDto = new CheckoutDTO();
        checkoutDto.setRentalDayCount(5);
        checkoutDto.setDiscountPercent(10);

        Checkout savedCheckout = new Checkout();
        when(checkoutRepository.save(any(Checkout.class))).thenReturn(savedCheckout);

        Checkout createdCheckout = checkoutServiceImpl.createCheckout(checkoutDto);

        assertNotNull(createdCheckout);
    }

    @Test
    public void testGetCheckoutById() {
        Checkout checkout = new Checkout();
        when(checkoutRepository.findById(1L)).thenReturn(Optional.of(checkout));

        Checkout retrievedCheckout = checkoutServiceImpl.getCheckoutById(1L);

        assertNotNull(retrievedCheckout);
    }

}
