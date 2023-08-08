package com.tool.rental.core.toolrental.controller;

import com.tool.rental.core.toolrental.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        CustomerDto customerDto = CustomerDto.
                builder()
                .firstName("Mike")
                .build();
        List<CustomerDto> customers = new ArrayList<>();
        customers.add(customerDto);
        return ResponseEntity.ok(customers);
    }
}
