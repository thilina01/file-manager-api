package com.trendsmixed.fma.module.workcenter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.CostCenter;
import com.trendsmixed.fma.entity.WorkCenter;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.costcenter.CostCenterService;

@RestController
@CrossOrigin
@RequestMapping("/workCenters")
public class WorkCenterController {

	@Autowired
	private AppSessionService appSessionService;
	@Autowired
	private WorkCenterService service;
	@Autowired
	private CostCenterService costCenterService;

	@GetMapping
	@JsonView(WorkCenterView.AllAndCostCenterAll.class)
	public Iterable<WorkCenter> findAll() {
		return service.findAll();
	}

	@PostMapping
	public WorkCenter save(@RequestBody WorkCenter workCenter,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);
		try {
			workCenter = service.save(workCenter);
			return workCenter;

		} catch (Throwable e) {
			while (e.getCause() != null) {
				e = e.getCause();
			}
			throw new Error(e.getMessage());
		}
	}

	@PostMapping("/many")
	public void saveMany(@RequestBody List<WorkCenter> workCenters,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

		appSessionService.isValid(email, request);
		try {
			for (WorkCenter workCenter : workCenters) {
				workCenter.setCode(workCenter.getCode().trim());
				workCenter.setName(workCenter.getName().trim());
				WorkCenter existingWorkCenter = service.findByCode(workCenter.getCode());
				if (existingWorkCenter != null) {
					workCenter.setId(existingWorkCenter.getId());
				}
				CostCenter costCenter = workCenter.getCostCenter();
				if (costCenter != null) {
					costCenter = costCenterService.findByCode(costCenter.getCode());
					workCenter.setCostCenter(costCenter);
				}
			}
			service.save(workCenters);
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

	@GetMapping("/{id}")
	public WorkCenter findOne(@PathVariable("id") int id) {
		return service.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
			HttpServletRequest request) {
		appSessionService.isValid(email, request);
		service.delete(id);

	}

	@PutMapping("/{id}")
	public WorkCenter updateCustomer(@PathVariable int id, @RequestBody WorkCenter workCenter,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);
		workCenter.setId(id);
		workCenter = service.save(workCenter);
		return workCenter;
	}

}
