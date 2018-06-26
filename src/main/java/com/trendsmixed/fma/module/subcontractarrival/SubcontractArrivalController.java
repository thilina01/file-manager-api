package com.trendsmixed.fma.module.subcontractarrival;

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
@RequestMapping("/subcontractArrivals")
public class SubcontractArrivalController {

    private final SubcontractArrivalService service;

    @JsonView(SubcontractArrivalView.All.class)
    @GetMapping
    public Iterable<SubcontractArrival> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractArrivalView.AllAndSubcontractOperationAndSubcontractNote.class)
    @GetMapping("/page")
    Page<SubcontractArrival> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<SubcontractArrival> subcontractArrivalList) {

        try {

            service.save(subcontractArrivalList);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    // @PostMapping("/release")
    // public SubcontractArrival saveReleaseInformation(@RequestBody SubcontractArrival subcontractArrival, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
    //     appSessionService.isValid(email, request);
    //     try {
    //         SubcontractArrival existingSubcontractArrival = service.findOne(subcontractArrival.getId());
    //         existingSubcontractArrival.setRecipient(subcontractArrival.getRecipient());
    //         existingSubcontractArrival.setContainerNumber(subcontractArrival.getContainerNumber());
    //         existingSubcontractArrival.setVehicleNumber(subcontractArrival.getVehicleNumber());
    //         existingSubcontractArrival.setSubcontractReleaseTime(subcontractArrival.getSubcontractReleaseTime());
    //         existingSubcontractArrival.setLocation(subcontractArrival.getLocation());
    //         return service.save(existingSubcontractArrival);

    //     } catch (Throwable e) {
    //         while (e.getCause() != null) {
    //             e = e.getCause();
    //         }
    //         throw new Error(e.getMessage());
    //     }
    // }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public SubcontractArrival save(@RequestBody SubcontractArrival subcontractArrival) {

        try {
            subcontractArrival = service.save(subcontractArrival);
            return subcontractArrival;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractArrivalView.AllAndSubcontractOperationAndSubcontractNote.class)
    @GetMapping("/{id}")
    public SubcontractArrival findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {

        service.delete(id);

    }

    @PutMapping("/{id}")
    public SubcontractArrival updateCustomer(@PathVariable int id, @RequestBody SubcontractArrival subcontractArrival) {

        subcontractArrival.setId(id);
        subcontractArrival = service.save(subcontractArrival);
        return subcontractArrival;
    }
}
