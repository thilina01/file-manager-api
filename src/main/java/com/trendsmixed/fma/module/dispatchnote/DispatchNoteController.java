package com.trendsmixed.fma.module.dispatchnote;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.trendsmixed.fma.utility.Format;
import java.text.ParseException;
import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.utility.Page;
import com.trendsmixed.fma.module.loadingplan.LoadingPlan;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanService;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.dispatch.Dispatch;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/dispatchNotes")
public class DispatchNoteController {

    private final AppSessionService appSessionService;
    private final DispatchNoteService service;
    private final LoadingPlanService loadingPlanService;

    @JsonView(DispatchNoteView.AllAndCustomerAndLocation.class)
    @GetMapping
    public Iterable<DispatchNote> findAll() {
        return service.findAll();
    }

    @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndLocation.class)
    @GetMapping("/page")
    Page<DispatchNote> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));

    }
    @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndLocation.class)
    @GetMapping(value = "/dispatchNoteDurationPage", params = {"startDate", "endDate"})
    public Page<DispatchNote> dispatchNoteDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByDispatchDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndLocation.class)
    @GetMapping(value = "/dispatchDateAndLocationPage", params = {"dispatchDate", "location"})
    public Page<DispatchNote> dispatchDateAndLocationPage(@RequestParam("dispatchDate") String dispatchDate, @RequestParam("location") String location, Pageable pageable) throws ParseException {
        return new Page(service.findByDispatchDateAndLocation(Format.yyyy_MM_dd.parse(dispatchDate), new Location(Integer.valueOf(location)), pageable));
    }
    @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndLocation.class)
    @GetMapping(value = "/dispatchNoteDurationAndLocationPage", params = {"startDate", "endDate", "location"})
    public Page<DispatchNote> dispatchNoteDurationAndLocationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("location") String location, Pageable pageable) throws ParseException {
        return new Page(service.findByDispatchDateBetweenAndLocation(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Location(Integer.valueOf(location)), pageable));
    }
    @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndLocation.class)
    @GetMapping(value = "/customerAndDispatchNoteDurationPage", params = {"customer", "startDate", "endDate"})
    public Page<DispatchNote> customerAndDispatchNoteDurationPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerAndDispatchDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndLocation.class)
    @GetMapping(value = "/customerAndDispatchDateAndLocationPage", params = {"customer", "dispatchDate", "location"})
    public Page<DispatchNote> customerAndDispatchDateAndLocationPage(@RequestParam("customer") String customer, @RequestParam("dispatchDate") String dispatchDate, @RequestParam("location") String location, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerAndDispatchDateAndLocation(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(dispatchDate), new Location(Integer.valueOf(location)), pageable));
    }
    @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndLocation.class)
    @GetMapping(value = "/customerAndDispatchNoteDurationAndLocationPage", params = {"customer", "startDate", "endDate", "location"})
    public Page<DispatchNote> customerAndDispatchNoteDurationAndLocationPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("location") String location, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerAndDispatchDateBetweenAndLocation(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Location(Integer.valueOf(location)), pageable));
    }
    
    @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndLocation.class)
    @GetMapping(value = "/dispatchDateAndCustomerPage", params = {"dispatchDate", "customer"})
    public Page<DispatchNote> dispatchDateAndCustomerPage(@RequestParam("dispatchDate") String dispatchDate, @RequestParam("customer") String customer, Pageable pageable) throws ParseException {
        return new Page(service.findByDispatchDateAndCustomer(Format.yyyy_MM_dd.parse(dispatchDate), new Customer(Integer.valueOf(customer)), pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddress.class)
    @GetMapping("/customer/{id}")
    public Iterable<DispatchNote> findByCustomer(@PathVariable("id") int id) {
        return service.findByCustomer(new Customer(id));
    }

    @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddress.class)
    @GetMapping("/customerAndInvoiceIsNull/{id}")
    public Iterable<DispatchNote> findByCustomerAndInvoiceIsNull(@PathVariable("id") int id) {
        return service.findByCustomerAndInvoiceIsNull(new Customer(id));
    }
    

    // @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndLocation.class)
    // @GetMapping("/id/{id}")
    // public DispatchNote findById(@PathVariable("id") String id) {
    //     return service.findById(id);
    // }

    @JsonView(DispatchNoteView.AllAndCustomerAndLocation.class)
    @PostMapping
    public DispatchNote save(@RequestBody DispatchNote dispatchNote, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            List<Dispatch> dispatches = dispatchNote.getDispatchList();
            if (dispatches != null) {
                for (Dispatch dispatch : dispatches) {
                    dispatch.setDispatchNote(dispatchNote);
                }
            }

            List<LoadingPlan> loadingPlansToUpdate = new ArrayList(); 
            List<LoadingPlan> loadingPlans = dispatchNote.getLoadingPlanList();
                      
                      if (loadingPlans != null) {
                          for (LoadingPlan loadingPlan : loadingPlans) {
                            LoadingPlan loadingPlanToUpdate = loadingPlanService.findOne(loadingPlan.getId());
                            loadingPlanToUpdate.setDispatchNote(dispatchNote);
                            loadingPlansToUpdate.add(loadingPlanToUpdate);
                          }
                          dispatchNote.setLoadingPlanList(loadingPlansToUpdate);
                     }
 
            dispatchNote = service.save(dispatchNote);
            return dispatchNote;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DispatchNoteView.AllAndCustomerAndLocation.class)
    @PostMapping("/release")
    public DispatchNote saveReleaseInformation(@RequestBody DispatchNote dispatchNote, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            DispatchNote existingDispatchNote = service.findOne(dispatchNote.getId());
            existingDispatchNote.setRecipient(dispatchNote.getRecipient());
            existingDispatchNote.setContainerNumber(dispatchNote.getContainerNumber());
            existingDispatchNote.setVehicleNumber(dispatchNote.getVehicleNumber());
            existingDispatchNote.setDispatchReleaseTime(dispatchNote.getDispatchReleaseTime());
            existingDispatchNote.setLocation(dispatchNote.getLocation());
            return service.save(existingDispatchNote);

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<DispatchNote> dispatchNotes, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(dispatchNotes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndLocation.class)
    @GetMapping("/{id}")
    public DispatchNote findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(DispatchNoteView.AllAndCustomerAndLocation.class)
    @PutMapping("/{id}")
    public DispatchNote updateCustomer(@PathVariable int id, @RequestBody DispatchNote dispatchNote, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        dispatchNote.setId(id);
        dispatchNote = service.save(dispatchNote);
        return dispatchNote;
    }

}
