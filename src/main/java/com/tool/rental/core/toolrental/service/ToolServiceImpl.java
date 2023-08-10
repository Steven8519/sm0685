package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.ToolDTO;
import com.tool.rental.core.toolrental.entity.Tool;
import com.tool.rental.core.toolrental.repository.ToolRepository;
import com.tool.rental.core.toolrental.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToolServiceImpl implements ToolService {
    private final ToolRepository toolRepository;

    public ToolServiceImpl(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }


    @Override
    public Tool createTool(ToolDTO toolDto) {
        Tool tool = new Tool();


        tool.setToolCode(toolDto.getToolCode());
        tool.setToolType(toolDto.getToolType());
        tool.setBrand(toolDto.getBrand());
        tool.setDailyCharge(toolDto.getDailyCharge());
        tool.setWeekdayCharge(toolDto.isWeekdayCharge());
        tool.setWeekendCharge(toolDto.isWeekendCharge());
        tool.setHolidayCharge(toolDto.isHolidayCharge());

        return toolRepository.save(tool);
    }

    @Override
    public Tool getToolById(Long id) {
        return toolRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tool not found"));
    }

    @Override
    public List<ToolDTO> getAllTools() {
        List<Tool> tools = toolRepository.findAll();

        List<ToolDTO> toolDtos = tools.stream()
                .map(tool -> convertToDto(tool))
                .collect(Collectors.toList());

        return toolDtos;
    }
    @Override
    public ToolDTO convertToDto(Tool tool) {
        ToolDTO toolDto = new ToolDTO();
        toolDto.setId(tool.getId());
        toolDto.setToolCode(tool.getToolCode());
        toolDto.setToolType(tool.getToolType());
        toolDto.setBrand(tool.getBrand());
        toolDto.setDailyCharge(tool.getDailyCharge());
        toolDto.setWeekdayCharge(tool.isWeekdayCharge());
        toolDto.setWeekendCharge(tool.isWeekendCharge());
        toolDto.setHolidayCharge(tool.isHolidayCharge());

        return toolDto;
    }
}
