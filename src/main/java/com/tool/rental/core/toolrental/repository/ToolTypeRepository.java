package com.tool.rental.core.toolrental.repository;

import com.tool.rental.core.toolrental.entity.ToolType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolTypeRepository extends JpaRepository<ToolType, Long> {
}
