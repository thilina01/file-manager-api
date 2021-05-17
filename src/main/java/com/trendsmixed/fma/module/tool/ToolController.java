package com.trendsmixed.fma.module.tool;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/tools")
public class ToolController {

    
    private final ToolService service;

    @JsonView(ToolView.All.class)
    @GetMapping
    public Iterable< Tool> findAll() {
        return service.findAll();
    }

    @JsonView(ToolView.All.class)
    @GetMapping("/page")
    Page< Tool> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ToolView.All.class)
    @PostMapping
    public Tool save(@RequestBody Tool tool) {
        
        try {
            tool = service.save(tool);
            return tool;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List< Tool> tools) {

        
        try {
            for (Tool tool : tools) {
                tool.setCode(tool.getCode().trim());
                tool.setName(tool.getName().trim());
                Tool existingTool = service.findByCode(tool.getCode());
                if (existingTool != null) {
                    tool.setId(existingTool.getId());
                }
            }
            service.save(tools);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ToolView.All.class)
    @GetMapping("/{id}")
    public Tool findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public Tool updateCustomer(@PathVariable int id, @RequestBody Tool tool) {
        
        tool.setId(id);
        tool = service.save(tool);
        return tool;
    }
}
