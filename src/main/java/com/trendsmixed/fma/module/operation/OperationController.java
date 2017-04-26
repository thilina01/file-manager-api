package com.trendsmixed.fma.module.operation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.trendsmixed.fma.entity.Operation;
import com.trendsmixed.fma.module.appsession.AppSessionService;

@RestController
@CrossOrigin
@RequestMapping("/operations")
public class OperationController {

	@Autowired
	private AppSessionService appSessionService;
	@Autowired
	private OperationService operationService;

	@JsonView(OperationView.AllJobAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll.class)
	@GetMapping
	public List<Operation> findAll() {
		return operationService.findAll();
	}

	@JsonView(OperationView.All.class)
	@PostMapping
	public Operation save(@RequestBody Operation operation,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);
		try {
			operation = operationService.save(operation);
			return operation;

		} catch (Throwable e) {
			while (e.getCause() != null) {
				e = e.getCause();
			}
			throw new Error(e.getMessage());
		}
	}

	@PostMapping("/many")
	public void saveMany(@RequestBody List<Operation> operations,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

		appSessionService.isValid(email, request);
		try {
			operationService.save(operations);
		} catch (Throwable e) {
			while (e.getCause() != null) {
				e = e.getCause();
			}
			throw new Error(e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public Operation findOne(@PathVariable("id") int id) {
		return operationService.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
			HttpServletRequest request) {
		appSessionService.isValid(email, request);
		operationService.delete(id);

	}

	@PutMapping("/{id}")
	public Operation updateCustomer(@PathVariable int id, @RequestBody Operation operation,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);
		operation.setId(id);
		operation = operationService.save(operation);
		return operation;
	}

	@GetMapping("/test")
	public List test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
		Date startDate = new Date(), endDate = new Date();
		try {
			startDate = sdf.parse("2017-02-01 00:00");
			endDate = sdf.parse("2017-02-28 23:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return operationService.test(startDate, endDate);
	}
}