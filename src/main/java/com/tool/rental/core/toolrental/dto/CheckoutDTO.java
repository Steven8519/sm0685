package com.tool.rental.core.toolrental.dto;

import com.tool.rental.core.toolrental.entity.Tool;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutDTO {
    private Long id;
    private Tool tool;
    private int rentalDayCount;
    private int discountPercent;
    private LocalDate checkoutDate;
}
