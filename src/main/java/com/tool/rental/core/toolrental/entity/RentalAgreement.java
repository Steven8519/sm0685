package com.tool.rental.core.toolrental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentalAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String toolCode;
    private String toolType;
    private String toolBrand;
    private int rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private double dailyRentalCharge;
    private int chargeDays;
    private double preDiscountCharge;
    private int discountPercent;
    private double discountAmount;
    private double finalCharge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tool_id")
    private Tool tool;

    public String getFormattedDiscountPercent() {
        return "Percent " + discountPercent + "%";
    }

    public void printRentalAgreement() {
        System.out.println("Rental Agreement Details:");
        System.out.println("Tool Code: " + toolCode);
        System.out.println("Tool Type: " + toolType);
        System.out.println("Tool Brand: " + toolBrand);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Checkout Date: " + checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
        System.out.println("Due Date: " + dueDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
        System.out.println("Daily Rental Charge: " + NumberFormat.getCurrencyInstance(Locale.US).format(dailyRentalCharge));
        System.out.println("Charge Days: " + chargeDays);
        System.out.println("Pre-discount Charge: " + NumberFormat.getCurrencyInstance(Locale.US).format(preDiscountCharge));
        System.out.println("Discount Percent: " + getFormattedDiscountPercent());
        System.out.println("Discount Amount: " + NumberFormat.getCurrencyInstance(Locale.US).format(discountAmount));
        System.out.println("Final Charge: " + NumberFormat.getCurrencyInstance(Locale.US).format(finalCharge));
    }
}
