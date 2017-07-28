package com.trendsmixed.fma.module.shifttype;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/shiftTypes")
public class ShiftTypeController {

	@Autowired
	private AppSessionService appSessionService;
	@Autowired
	private ShiftTypeService service;

	@JsonView(ShiftTypeView.All.class)
	@GetMapping
	public Iterable<ShiftType> findAll() {
		return service.findAll();
	}

	@JsonView(ShiftTypeView.All.class)
	@GetMapping("/page")
	Page<ShiftType> page(Pageable pageable) {
		return service.findAll(pageable);
	}

	@GetMapping("/combo")
	List<Combo> combo() {
		return service.getCombo();
	}

	@PostMapping
	public ShiftType save(@RequestBody ShiftType shiftType,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);
		try {
			shiftType = service.save(shiftType);
			return shiftType;

		} catch (Throwable e) {
			while (e.getCause() != null) {
				e = e.getCause();
			}
			throw new Error(e.getMessage());
		}
	}

	@PostMapping("/many")
	public void saveMany(@RequestBody List<ShiftType> shiftTypes,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);
		try {

			service.save(shiftTypes);
		} catch (Throwable e) {
			while (e.getCause() != null) {
				e = e.getCause();
			}
			throw new Error(e.getMessage());
		}
	}

	@JsonView(ShiftTypeView.All.class)
	@GetMapping("/{id}")
	public ShiftType findOne(@PathVariable("id") int id) {
		return service.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
			HttpServletRequest request) {
		appSessionService.isValid(email, request);
		service.delete(id);

	}

	@PutMapping("/{id}")
	public ShiftType updateCustomer(@PathVariable int id, @RequestBody ShiftType shiftType,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);
		shiftType.setId(id);
		shiftType = service.save(shiftType);
		return shiftType;
	}
}
