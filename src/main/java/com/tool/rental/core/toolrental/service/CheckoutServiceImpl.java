package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.CheckoutDTO;
import com.tool.rental.core.toolrental.entity.Checkout;
import com.tool.rental.core.toolrental.entity.Tool;
import com.tool.rental.core.toolrental.exceptions.NotFoundException;
import com.tool.rental.core.toolrental.repository.CheckoutRepository;
import com.tool.rental.core.toolrental.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final ToolRepository toolRepository;

    @Autowired
    public CheckoutServiceImpl(CheckoutRepository checkoutRepository, ToolRepository toolRepository) {
        this.checkoutRepository = checkoutRepository;
        this.toolRepository = toolRepository;
    }

    @Override
    public Checkout createCheckout(CheckoutDTO checkoutDto) {
        Checkout checkout = new Checkout();
        Tool tool = toolRepository.findByToolCode(checkoutDto.getToolCode());
        checkout.setTool(tool);

        return checkoutRepository.save(checkout);
    }

    public Checkout getCheckoutById(Long id) {
        return checkoutRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Checkout not found"));
    }
    @Override
    public CheckoutDTO convertToDto(Checkout checkout) {
        CheckoutDTO checkoutDto = new CheckoutDTO();
        checkoutDto.setId(checkout.getId());
        checkoutDto.setToolCode(checkout.getTool().getToolCode());
        checkoutDto.setCheckoutDate(checkout.getCheckoutDate());
        checkoutDto.setRentalDayCount(checkout.getRentalDayCount());
        checkoutDto.setDiscountPercent(checkout.getDiscountPercent());

        return checkoutDto;
    }
}
