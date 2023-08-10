package com.tool.rental.core.toolrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalAgreementDTO {
    private Long id;
    private String toolCode;
    private LocalDate checkoutDate;
    private int rentalDays;
    private int discountPercent;
}
