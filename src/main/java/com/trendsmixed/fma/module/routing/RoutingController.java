package com.trendsmixed.fma.module.routing;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.controlpoint.ControlPointService;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.item.ItemService;
import com.trendsmixed.fma.module.materialtype.MaterialType;
import com.trendsmixed.fma.module.materialtype.MaterialTypeService;
import com.trendsmixed.fma.module.operationtype.OperationType;
import com.trendsmixed.fma.module.operationtype.OperationTypeService;
import com.trendsmixed.fma.module.skill.Skill;
import com.trendsmixed.fma.module.skill.SkillService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/routings")
public class RoutingController {

    private final RoutingService service;
    private final ItemService itemService;
    private final ControlPointService controlPointService;
    private final SkillService skillService;
    private final OperationTypeService operationTypeService;
    private final MaterialTypeService materialTypeService;

    @GetMapping
    @JsonView(RoutingView.All.class)
    public Iterable<Routing> findAll() {
        return service.findAll();
    }

    @JsonView(RoutingView.All.class)
    @GetMapping("/page")
    Page<Routing> page(Pageable pageable) {
        return new Page<Routing>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    @JsonView(RoutingView.All.class)
    public Routing save(@RequestBody Routing routing) {

        try {
            routing = service.save(routing);
            return routing;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    //    @JsonView(RoutingView.All.class)
    @PostMapping("/many")
    public void saveMany(@RequestBody List<Routing> routings) {
        cleanse(routings);
        try {
            service.save(routings);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    private void cleanse(List<Routing> routings) {
        for (Routing routing : routings) {
            cleanse(routing);
        }
    }

    private void cleanse(Routing routing) {
        Item item = routing.getItem();
        if (item != null) {
            if (item.getId() == null || item.getId() == 0 || item.getId() == -1) {
                Item existingItem = itemService.findByCode(item.getCode());
                if (existingItem != null) {
                    item.setId(existingItem.getId());
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item with code [" + item.getCode() + "] not found");
                }
            }
        }

        ControlPoint controlPoint = routing.getControlPoint();
        if (controlPoint != null) {
            if (controlPoint.getId() == null || controlPoint.getId() == 0 || controlPoint.getId() == -1) {
                ControlPoint existingControlPoint = controlPointService.findByCode(controlPoint.getCode());
                if (existingControlPoint != null) {
                    controlPoint.setId(existingControlPoint.getId());
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Control Point with code [" + controlPoint.getCode() + "] not found");
                }
            }
        }

        Skill skill = routing.getSkill();
        if (skill != null) {
            if (skill.getId() == null || skill.getId() == 0 || skill.getId() == -1) {
                Skill existingSkill = skillService.findByCode(skill.getCode());
                if (existingSkill != null) {
                    skill.setId(existingSkill.getId());
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "skill with code [" + skill.getCode() + "] not found");
                }
            }
        }

        OperationType operationType = routing.getOperationType();
        if (operationType != null) {
            if (operationType.getId() == null || operationType.getId() == 0 || operationType.getId() == -1) {
                OperationType existingOperationType = operationTypeService.findByCode(operationType.getCode());
                if (existingOperationType != null) {
                    operationType.setId(existingOperationType.getId());
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "operationType with code [" + operationType.getCode() + "] not found");
                }
            }
        }

        MaterialType materialType = routing.getMaterialType();
        if (materialType != null) {
            if (materialType.getId() == null || materialType.getId() == 0 || materialType.getId() == -1) {
                MaterialType existingMaterialType = materialTypeService.findByCode(materialType.getCode());
                if (existingMaterialType != null) {
                    materialType.setId(existingMaterialType.getId());
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "materialType with code [" + materialType.getCode() + "] not found");
                }
            }
        }

    }

    @JsonView(RoutingView.All.class)
    @GetMapping("/{id}")
    public Routing findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }

    @JsonView(RoutingView.All.class)
    @PutMapping("/{id}")
    public Routing updateCustomer(@PathVariable int id, @RequestBody Routing routing) {
        routing.setId(id);
        routing = service.save(routing);
        return routing;
    }

}
