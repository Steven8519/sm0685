package com.tool.rental.core.toolrental.repository;

import com.tool.rental.core.toolrental.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
}
