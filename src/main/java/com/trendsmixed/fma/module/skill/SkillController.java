package com.trendsmixed.fma.module.skill;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/skills")
public class SkillController {

    private final SkillService service;

    @LogExecution
    @JsonView(SkillView.All.class)
    @PostMapping
    public Skill save(@RequestBody Skill skill) {
        
        try {
            skill = service.save(skill);
            return skill;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @GetMapping
    @JsonView(SkillView.All.class)
    public Iterable<Skill> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(SkillView.All.class)
    @GetMapping("/{id}")
    public Skill findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @LogExecution
    @JsonView(SkillView.All.class)
    @GetMapping("/page")
    Page<Skill> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @LogExecution
    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @LogExecution
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);
    }

    @LogExecution
    @PutMapping("/{id}")
    public Skill update(@PathVariable int id, @RequestBody Skill skill) {
        
        skill.setId(id);
        skill = service.save(skill);
        return skill;
    }
}
