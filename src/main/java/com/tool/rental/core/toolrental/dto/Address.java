package com.tool.rental.core.toolrental.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String address;

    private String address2;

    private String state;

    private String City;

    private String zipCode;

    private String country;

}
