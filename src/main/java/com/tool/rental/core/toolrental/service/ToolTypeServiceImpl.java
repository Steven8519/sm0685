package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.ToolTypeDTO;
import com.tool.rental.core.toolrental.entity.ToolType;
import com.tool.rental.core.toolrental.exceptions.NotFoundException;
import com.tool.rental.core.toolrental.repository.ToolTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolTypeServiceImpl implements ToolTypeService {

    private final ToolTypeRepository toolTypeRepository;
    @Autowired
    public ToolTypeServiceImpl(ToolTypeRepository toolTypeRepository) {
        this.toolTypeRepository = toolTypeRepository;
    }


    @Override
    public ToolType createToolType(ToolTypeDTO toolTypeDto) {
        ToolType toolType = new ToolType();
        toolType.setName(toolTypeDto.getName());


        // Save the tool type
        return toolTypeRepository.save(toolType);
    }

    @Override
    public ToolType getToolTypeById(Long id) {
        return toolTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tool type not found"));
    }

    @Override
    public ToolTypeDTO convertToDto(ToolType toolType) {
        ToolTypeDTO toolTypeDto = new ToolTypeDTO();
        toolTypeDto.setId(toolType.getId());
        toolTypeDto.setName(toolType.getName());

        return toolTypeDto;
    }
}
