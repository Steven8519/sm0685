package com.tool.rental.core.toolrental.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tool tool;

    private LocalDate checkoutDate;
    private int rentalDayCount;
    private int discountPercent;
}
