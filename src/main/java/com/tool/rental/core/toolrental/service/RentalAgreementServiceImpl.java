package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.RentalAgreementDTO;
import com.tool.rental.core.toolrental.entity.Tool;
import com.tool.rental.core.toolrental.entity.RentalAgreement;
import com.tool.rental.core.toolrental.exceptions.NotFoundException;
import com.tool.rental.core.toolrental.repository.RentalAgreementRepository;
import com.tool.rental.core.toolrental.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalAgreementServiceImpl implements RentalAgreementService{

    private final RentalAgreementRepository rentalAgreementRepository;
    private final ToolRepository toolRepository;
    @Autowired
    public RentalAgreementServiceImpl(RentalAgreementRepository rentalAgreementRepository, ToolRepository toolRepository) {
        this.rentalAgreementRepository = rentalAgreementRepository;
        this.toolRepository = toolRepository;
    }

    @Override
    public RentalAgreement createRentalAgreement(RentalAgreementDTO rentalAgreementDto) {
        RentalAgreement rentalAgreement = new RentalAgreement();
        Tool tool = toolRepository.findByToolCode(rentalAgreementDto.getToolCode());

        rentalAgreement.setTool(tool);
        rentalAgreement.setToolType(tool.getToolType());
        rentalAgreement.setToolBrand(tool.getBrand());
        rentalAgreement.setRentalDays(rentalAgreementDto.getRentalDays());
        rentalAgreement.setCheckoutDate(rentalAgreementDto.getCheckoutDate());

        return rentalAgreementRepository.save(rentalAgreement);
    }

    @Override
    public RentalAgreement getRentalAgreementById(Long id) {
        return rentalAgreementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rental agreement not found"));
    }

    @Override
    public RentalAgreementDTO convertToDto(RentalAgreement rentalAgreement) {
        RentalAgreementDTO rentalAgreementDto = new RentalAgreementDTO();
        rentalAgreementDto.setId(rentalAgreement.getId());
        rentalAgreementDto.setToolCode(rentalAgreement.getTool().getToolCode());
        rentalAgreementDto.setCheckoutDate(rentalAgreement.getCheckoutDate());
        rentalAgreementDto.setRentalDays(rentalAgreement.getRentalDays());
        rentalAgreementDto.setDiscountPercent(rentalAgreement.getDiscountPercent());

        return rentalAgreementDto;
    }
}
