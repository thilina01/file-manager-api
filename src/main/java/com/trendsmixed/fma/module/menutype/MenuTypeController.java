package com.trendsmixed.fma.module.menutype;

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
import com.trendsmixed.fma.entity.MenuType;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/menuTypes")
public class MenuTypeController {

	@Autowired
	private AppSessionService appSessionService;
	@Autowired
	private MenuTypeService service;

	@JsonView(MenuTypeView.All.class)
	@GetMapping
	public Iterable<MenuType> findAll() {
		return service.findAll();
	}

	@JsonView(MenuTypeView.All.class)
	@GetMapping("/page")
	Page<MenuType> page(Pageable pageable) {
		return service.findAll(pageable);
	}

	@GetMapping("/combo")
	List<Combo> combo() {
		return service.getCombo();
	}

	@PostMapping
	public MenuType save(@RequestBody MenuType menuType,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);
		try {
			menuType = service.save(menuType);
			return menuType;

		} catch (Throwable e) {
			while (e.getCause() != null) {
				e = e.getCause();
			}
			throw new Error(e.getMessage());
		}
	}

	@PostMapping("/many")
	public void saveMany(@RequestBody List<MenuType> menuTypes,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);
		try {

			service.save(menuTypes);
		} catch (Throwable e) {
			while (e.getCause() != null) {
				e = e.getCause();
			}
			throw new Error(e.getMessage());
		}
	}

	@JsonView(MenuTypeView.All.class)
	@GetMapping("/{id}")
	public MenuType findOne(@PathVariable("id") int id) {
		return service.findOne(id);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
			HttpServletRequest request) {
		appSessionService.isValid(email, request);
		service.delete(id);

	}

	@PutMapping("/{id}")
	public MenuType updateCustomer(@PathVariable int id, @RequestBody MenuType menuType,
			@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
		appSessionService.isValid(email, request);
		menuType.setId(id);
		menuType = service.save(menuType);
		return menuType;
	}
}
