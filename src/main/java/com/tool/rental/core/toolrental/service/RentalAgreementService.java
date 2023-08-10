package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.RentalAgreementDTO;
import com.tool.rental.core.toolrental.entity.RentalAgreement;

public interface RentalAgreementService {
    RentalAgreement createRentalAgreement(RentalAgreementDTO rentalAgreementDto);
    RentalAgreement getRentalAgreementById(Long id);
    RentalAgreementDTO convertToDto(RentalAgreement rentalAgreement);
}
