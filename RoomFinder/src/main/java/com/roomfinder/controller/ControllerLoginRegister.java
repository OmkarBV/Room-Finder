package com.roomfinder.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roomfinder.entity.Owner;
import com.roomfinder.entity.Tenant;
import com.roomfinder.service.ServiceLoginRegister;

@RestController
@CrossOrigin("http://localhost:4200")
public class ControllerLoginRegister {

	@Autowired
	ServiceLoginRegister service;

	@RequestMapping("/ownerlogin")
	public Map<String, Object> ownerLogin(@RequestBody Owner owner) {
		System.out.println(owner);
		return service.ownerLogin(owner);
	}

	@PostMapping("/ownerregister")
	public Map<String, Object> ownerRegister(@RequestBody Owner owner) {
		Map<String, Object> response = new HashMap<>();

		if (service.checkAlreadyRegister(owner)) {
			service.ownerRegister(owner);
			response.put("success", true);
			response.put("message", "registration success");
			return response;
		} else {
			response.put("success", false);
			response.put("message", "already registered");
			return response;
		}
	}

	@RequestMapping("/tenantlogin")
	public Map<String, Object> tenantLogin(@RequestBody Tenant tenant) {
		return service.tenantLogin(tenant);
	}

	@PostMapping("/tenantregister")
	public Map<String, Object> tenantRegister(@RequestBody Tenant tenant) {
		Map<String, Object> response = new HashMap<>();

		if (service.checkAlreadyRegister(tenant)) {
			service.tenantRegister(tenant);
			response.put("success", true);
			response.put("message", "registration success");
			return response;
		} else {
			response.put("success", false);
			response.put("message", "already registered");
			return response;
		}
	}
	
	@GetMapping("/gettenant/{email}")
	public Tenant getTenant(@PathVariable String email) {
		return service.getTenant(email);
	}
	
}
