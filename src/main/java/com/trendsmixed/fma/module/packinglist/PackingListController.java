package com.trendsmixed.fma.module.packinglist;

import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.trendsmixed.fma.utility.Page;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/packingLists")
public class PackingListController {

    private final AppSessionService appSessionService;
    private final PackingListService service;

    @JsonView(PackingListView.AllAndCustomerAndInvoiceTypeAndInvoiceDispatchNoteAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem.class)
    @GetMapping
    public Iterable<PackingList> findAll() {
        return service.findAll();
    }

    @JsonView(PackingListView.AllAndPortOfLoadingAndPortAllAndCountryAllAndAndEmployeeAllAndContainerSizeAllAndDispatchNoteAll.class)
    @GetMapping("/page")
    Page<PackingList> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(PackingListView.AllAndCustomerAndInvoiceTypeAndInvoiceDispatchNoteAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem.class)
    @GetMapping("/id/{id}")
    public PackingList findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @JsonView(PackingListView.AllAndCustomerAndInvoiceTypeAndInvoiceDispatchNoteAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem.class)
    @PostMapping
    public PackingList save(@RequestBody PackingList packingList, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            List<DispatchNote> dispatchNotes = packingList.getDispatchNoteList();
            
            if (dispatchNotes != null) {
                for (DispatchNote dispatchNote : dispatchNotes) {
                    dispatchNote.setPackingList(packingList);
                }
            }

            packingList = service.save(packingList);
            return service.save(packingList);

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(PackingListView.AllAndCustomerAndInvoiceTypeAndInvoiceDispatchNoteAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem.class)
    @PostMapping("/many")
    public void saveMany(@RequestBody List<PackingList> packingLists, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
           
            service.save(packingLists);

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(PackingListView.AllAndCustomerAndInvoiceTypeAndInvoiceDispatchNoteAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem.class)
    @GetMapping("/{id}")
    public PackingList findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(PackingListView.AllAndCustomerAndInvoiceTypeAndInvoiceDispatchNoteAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem.class)
    @PutMapping("/{id}")
    public PackingList updateCustomer(@PathVariable int id, @RequestBody PackingList packingList, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        packingList.setId(id);
        packingList = service.save(packingList);
        return packingList;
    }

}
