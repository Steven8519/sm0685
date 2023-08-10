package com.tool.rental.core.toolrental.controller;

import com.tool.rental.core.toolrental.dto.ToolDTO;
import com.tool.rental.core.toolrental.entity.Tool;
import com.tool.rental.core.toolrental.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tool")
public class ToolController {

    private final ToolService toolService;
    @Autowired
    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping("/create")
    public ResponseEntity<ToolDTO> createTool(@RequestBody ToolDTO toolDto) {
        Tool tool = toolService.createTool(toolDto);
        return ResponseEntity.ok(toolService.convertToDto(tool));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ToolDTO> getToolById(@PathVariable Long id) {
        Tool tool = toolService.getToolById(id);
        return ResponseEntity.ok(toolService.convertToDto(tool));
    }
}






