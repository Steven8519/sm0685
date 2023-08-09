package com.tool.rental.core.toolrental.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tool_code", referencedColumnName = "toolCode")
    private Tool tool;
    private int rentalDayCount;
    private int discountPercent;
    private LocalDate checkoutDate;
}
