package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.ToolTypeDTO;
import com.tool.rental.core.toolrental.entity.ToolType;

public interface ToolTypeService {
    ToolType createToolType(ToolTypeDTO toolTypeDto);
    ToolType getToolTypeById(Long id);
    ToolTypeDTO convertToDto(ToolType toolType);
}
