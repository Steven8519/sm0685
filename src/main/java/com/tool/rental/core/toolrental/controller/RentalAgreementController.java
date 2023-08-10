package com.tool.rental.core.toolrental.controller;

import com.tool.rental.core.toolrental.dto.RentalAgreementDTO;
import com.tool.rental.core.toolrental.entity.RentalAgreement;
import com.tool.rental.core.toolrental.service.RentalAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rental")
public class RentalAgreementController {

    private final RentalAgreementService rentalAgreementService;

    @Autowired
    public RentalAgreementController(RentalAgreementService rentalAgreementService) {
        this.rentalAgreementService = rentalAgreementService;
    }

    @PostMapping("/create")
    public ResponseEntity<RentalAgreementDTO> createRentalAgreement(@RequestBody RentalAgreementDTO rentalAgreementDto) {
        RentalAgreement rentalAgreement = rentalAgreementService.createRentalAgreement(rentalAgreementDto);
        return ResponseEntity.ok(rentalAgreementService.convertToDto(rentalAgreement));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalAgreementDTO> getRentalAgreementById(@PathVariable Long id) {
        RentalAgreement rentalAgreement = rentalAgreementService.getRentalAgreementById(id);
        return ResponseEntity.ok(rentalAgreementService.convertToDto(rentalAgreement));
    }

}
