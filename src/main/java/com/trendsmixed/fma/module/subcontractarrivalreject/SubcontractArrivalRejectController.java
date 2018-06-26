package com.trendsmixed.fma.module.subcontractarrivalreject;

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
@RequestMapping("/subcontractArrivalRejects")
public class SubcontractArrivalRejectController {

    private final SubcontractArrivalRejectService service;

    @JsonView(SubcontractArrivalRejectView.All.class)
    @GetMapping
    public Iterable<SubcontractArrivalReject> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractArrivalRejectView.AllAndLossReasonAndSubcontractArrival.class)
    @GetMapping("/page")
    Page<SubcontractArrivalReject> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<SubcontractArrivalReject> subcontractArrivalRejectList) {

        try {

            service.save(subcontractArrivalRejectList);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    // @PostMapping("/release")
    // public SubcontractArrivalReject saveReleaseInformation(@RequestBody SubcontractArrivalReject subcontractArrivalReject, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
    //     appSessionService.isValid(email, request);
    //     try {
    //         SubcontractArrivalReject existingSubcontractArrivalReject = service.findOne(subcontractArrivalReject.getId());
    //         existingSubcontractArrivalReject.setRecipient(subcontractArrivalReject.getRecipient());
    //         existingSubcontractArrivalReject.setContainerNumber(subcontractArrivalReject.getContainerNumber());
    //         existingSubcontractArrivalReject.setVehicleNumber(subcontractArrivalReject.getVehicleNumber());
    //         existingSubcontractArrivalReject.setSubcontractReleaseTime(subcontractArrivalReject.getSubcontractReleaseTime());
    //         existingSubcontractArrivalReject.setLocation(subcontractArrivalReject.getLocation());
    //         return service.save(existingSubcontractArrivalReject);

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
    public SubcontractArrivalReject save(@RequestBody SubcontractArrivalReject subcontractArrivalReject) {

        try {
            subcontractArrivalReject = service.save(subcontractArrivalReject);
            return subcontractArrivalReject;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractArrivalRejectView.AllAndLossReasonAndSubcontractArrival.class)
    @GetMapping("/{id}")
    public SubcontractArrivalReject findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {

        service.delete(id);

    }

    @PutMapping("/{id}")
    public SubcontractArrivalReject updateCustomer(@PathVariable int id, @RequestBody SubcontractArrivalReject subcontractArrivalReject) {

        subcontractArrivalReject.setId(id);
        subcontractArrivalReject = service.save(subcontractArrivalReject);
        return subcontractArrivalReject;
    }
}
