package com.tool.rental.core.toolrental.repository;

import com.tool.rental.core.toolrental.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {

}
