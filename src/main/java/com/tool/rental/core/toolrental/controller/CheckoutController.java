package com.tool.rental.core.toolrental.controller;

import com.tool.rental.core.toolrental.dto.CheckoutDTO;
import com.tool.rental.core.toolrental.entity.Checkout;
import com.tool.rental.core.toolrental.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/create")
    public ResponseEntity<CheckoutDTO> createCheckout(@RequestBody CheckoutDTO checkoutDto) {
        Checkout checkout = checkoutService.createCheckout(checkoutDto);
        return ResponseEntity.ok(checkoutService.convertToDto(checkout));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckoutDTO> getCheckoutById(@PathVariable Long id) {
        Checkout checkout = checkoutService.getCheckoutById(id);
        return ResponseEntity.ok(checkoutService.convertToDto(checkout));
    }
}
