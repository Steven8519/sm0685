package com.tool.rental.core.toolrental.dto;

import com.tool.rental.core.toolrental.entity.Tool;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayDTO {
    private Long id;
    private boolean weekdayCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;
    private BigDecimal dailyCharge;
    private List<Tool> tools;
}
