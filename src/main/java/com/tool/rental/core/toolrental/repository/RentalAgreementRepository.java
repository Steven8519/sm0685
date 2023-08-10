package com.tool.rental.core.toolrental.repository;

import com.tool.rental.core.toolrental.entity.RentalAgreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalAgreementRepository extends JpaRepository<RentalAgreement, Long> {
}
