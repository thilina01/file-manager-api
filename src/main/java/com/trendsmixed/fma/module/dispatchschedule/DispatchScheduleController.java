package com.trendsmixed.fma.module.dispatchschedule;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/dispatchSchedules")
public class DispatchScheduleController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private DispatchScheduleService service;

    @JsonView(DispatchScheduleView.All.class)
    @GetMapping
    public Iterable<DispatchSchedule> findAll() {
        return service.findAll();
    }

    @JsonView(DispatchScheduleView.All.class)
    @GetMapping("/page")
    Page<DispatchSchedule> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @JsonView(DispatchScheduleView.All.class)
    @PostMapping
    public DispatchSchedule save(@RequestBody DispatchSchedule dispatchSchedule, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
//            DispatchSchedule existingDispatchSchedule = service.findByDispatchScheduleNo(dispatchSchedule.getDispatchScheduleNo());
//            if ((dispatchSchedule.getId() == null || dispatchSchedule.getId() == 0) && existingDispatchSchedule != null) {
//                throw new Error("DispatchSchedule Number Already Used!");
//            }
//            if (existingDispatchSchedule == null) {
//                dispatchSchedule.setRemainingQuantity(dispatchSchedule.getQuantity());
//            }
            return service.save(dispatchSchedule);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

//    @PostMapping("/many")
//    public void saveMany(@RequestBody List<DispatchSchedule> dispatchSchedules, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
//
//        appSessionService.isValid(email, request);
//        try {
//            List<DispatchSchedule> dispatchSchedulesToSave = new ArrayList<>();
//            for (DispatchSchedule dispatchSchedule : dispatchSchedules) {
//                DispatchSchedule existingDispatchSchedule = service.findByDispatchScheduleNo(dispatchSchedule.getDispatchScheduleNo());
//                if (existingDispatchSchedule != null) {
//                    dispatchSchedule.setId(existingDispatchSchedule.getId());
//                }
//                DispatchScheduleType dispatchScheduleType = dispatchSchedule.getDispatchScheduleType();
//                if (dispatchScheduleType != null) {
//                    String dispatchScheduleTypeCode = dispatchScheduleType.getCode().trim();
//                    if (dispatchScheduleTypeCode != null) {
//                        dispatchScheduleType = dispatchScheduleTypeService.findByCode(dispatchScheduleTypeCode);
//                        if (dispatchScheduleType == null) {
//                            dispatchScheduleType = new DispatchScheduleType();
//                            dispatchScheduleType.setCode(dispatchScheduleTypeCode);
//                            dispatchScheduleType = dispatchScheduleTypeService.save(dispatchScheduleType);
//                        }
//                        dispatchSchedule.setDispatchScheduleType(dispatchScheduleType);
//                    }
//                }
//                Item item = dispatchSchedule.getItem();
//                if (item != null) {
//                    item = itemService.findByCode(item.getCode());
//                    if (item != null) {
//                        dispatchSchedule.setItem(item);
//                        dispatchSchedulesToSave.add(dispatchSchedule);
//                    }
//                }
//            }
//            service.save(dispatchSchedulesToSave);
//        } catch (Throwable e) {
//            e.printStackTrace();
//            while (e.getCause() != null) {
//                e = e.getCause();
//            }
//            throw new Error(e.getMessage());
//        }
//    }

    @JsonView(DispatchScheduleView.All.class)
    @GetMapping("/{id}")
    public DispatchSchedule findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @PutMapping("/{id}")
    public DispatchSchedule update(@PathVariable int id, @RequestBody DispatchSchedule dispatchSchedule, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        dispatchSchedule.setId(id);
        dispatchSchedule = service.save(dispatchSchedule);
        return dispatchSchedule;
    }
}
