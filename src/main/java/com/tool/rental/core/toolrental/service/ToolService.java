package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.ToolDTO;
import com.tool.rental.core.toolrental.entity.Tool;

import java.util.List;

public interface ToolService {
    Tool getToolById(Long id);
    ToolDTO convertToDto(Tool tool);

    List<ToolDTO> getAllTools();

    Tool createTool(ToolDTO toolDto);
}
