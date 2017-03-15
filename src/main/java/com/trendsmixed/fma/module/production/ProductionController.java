package com.trendsmixed.fma.module.production;

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
import com.trendsmixed.fma.entity.Manpower;
import com.trendsmixed.fma.entity.Operation;
import com.trendsmixed.fma.entity.Production;
import com.trendsmixed.fma.module.appsession.AppSessionService;

@RestController
@CrossOrigin
@RequestMapping("/productions")
public class ProductionController {

	@Autowired
	private AppSessionService appSessionService;
	@Autowired
	private ProductionService productionService;

	@JsonView(ProductionView.AllAndShiftAllAndControlPointAll.class)
	@GetMapping
	public List<Production> findAll() {
		return productionService.findAll();
	}

	@JsonView(ProductionView.All.class)
	@PostMapping
	public Production save(@RequestBody Production production,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		// appSessionService.isValid(email, request);
		try {
			List<Operation> operations = production.getOperationList();
			if (operations != null) {
				for (Operation operation : operations) {
					operation.setProduction(production);
				}
			}

			List<Manpower> manpowers = production.getManpowerList();
			if (manpowers != null) {
				for (Manpower manpower : manpowers) {
					manpower.setProduction(production);
				}
			}

			production = productionService.save(production);
			return production;

		} catch (Throwable e) {
			while (e.getCause() != null) {
				e = e.getCause();
			}
			throw new Error(e.getMessage());
		}
	}

	@JsonView(ProductionView.AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
	@PostMapping("/ByProductionDateAndShiftAndControlPoint")
	public Production ByProductionDateAndShiftAndControlPoint(@RequestBody Production production,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);

		return productionService.findByProductionDateAndShiftAndControlPoint(production.getProductionDate(),
				production.getShift(), production.getControlPoint());
	}

	@PostMapping("/many")
	public void saveMany(@RequestBody List<Production> productions,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

		appSessionService.isValid(email, request);
		try {
			productionService.save(productions);
		} catch (Throwable e) {
			while (e.getCause() != null) {
				e = e.getCause();
			}
			throw new Error(e.getMessage());
		}
	}

	@JsonView(ProductionView.AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll.class)
	@GetMapping("/{id}")
	public Production findOne(@PathVariable("id") int id) {
		return productionService.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
			HttpServletRequest request) {
		appSessionService.isValid(email, request);
		productionService.delete(id);
	}

	@PutMapping("/{id}")
	public Production updateCustomer(@PathVariable int id, @RequestBody Production production,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);
		production.setId(id);
		production = productionService.save(production);
		return production;
	}
}
