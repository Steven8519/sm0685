package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.CheckoutDTO;
import com.tool.rental.core.toolrental.entity.Checkout;

public interface CheckoutService {
    Checkout createCheckout(CheckoutDTO checkoutDto);
    Checkout getCheckoutById(Long id);
    CheckoutDTO convertToDto(Checkout checkout);
}
