package com.tool.rental.core.toolrental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Data
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean weekdayCharge;
    private boolean weekendCharge;
    private BigDecimal holidayCharge;

    @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL)
    private Set<Tool> tools = new HashSet<>();
}
