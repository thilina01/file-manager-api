package com.trendsmixed.fma.module.drawingchangerequest;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/drawingChangeRequests")
public class DrawingChangeRequestController {

    private final DrawingChangeRequestService service;

    @JsonView(DrawingChangeRequestView.All.class)
    @GetMapping
    public Iterable<DrawingChangeRequest> findAll() {
        return service.findAll();
    }

    @JsonView(DrawingChangeRequestView.AllAndDrawingVersion.class)
    @GetMapping("/page")
    Page<DrawingChangeRequest> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<DrawingChangeRequest> drawingChangeRequestList) {

        try {

            service.save(drawingChangeRequestList);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public DrawingChangeRequest save(@RequestBody DrawingChangeRequest drawingChangeRequest) {
        try {

      drawingChangeRequest = service.save(drawingChangeRequest);
            return drawingChangeRequest;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DrawingChangeRequestView.AllAndDrawingVersion.class)
    @GetMapping("/{id}")
    public DrawingChangeRequest findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @PutMapping("/{id}")
    public DrawingChangeRequest updateCustomer(@PathVariable int id, @RequestBody DrawingChangeRequest drawingChangeRequest) {
        drawingChangeRequest.setId(id);
        drawingChangeRequest = service.save(drawingChangeRequest);
        return drawingChangeRequest;
    }
}
