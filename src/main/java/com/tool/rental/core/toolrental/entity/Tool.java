package com.tool.rental.core.toolrental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String toolCode;

    @NotBlank
    private String toolType;

    @NotBlank
    private String toolBrand;

    @ManyToOne
    @JoinColumn(name = "holiday_id")
    private Holiday holiday;
}
