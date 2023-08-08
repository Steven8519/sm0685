package com.tool.rental.core.toolrental.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToolDTO implements Serializable {

    private Long id;

    @NotBlank(message = "Tool code is required")
    private String toolCode;

    @NotBlank(message = "Tool type is required")
    private String toolType;

    @NotBlank(message = "Tool brand is required")
    private String toolBrand;
}