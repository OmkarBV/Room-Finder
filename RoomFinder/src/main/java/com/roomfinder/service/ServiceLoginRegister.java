package com.roomfinder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomfinder.dao.DaoLoginRegister;
import com.roomfinder.entity.Owner;
import com.roomfinder.entity.Tenant;

@Service
public class ServiceLoginRegister {
	@Autowired
	DaoLoginRegister dao;

	public Map<String, Object> ownerLogin(Owner owner) {
		Map<String, Object> response = new HashMap<>();

		List<Owner> s = dao.ownerLogin(owner);
		if (s.isEmpty()) {
			response.put("success", false);
			response.put("message", "Invalid User");
			return response;
		} else {
			if (s.get(0).getEmail().equals(owner.getEmail()) && s.get(0).getPassword().equals(owner.getPassword())) {
				response.put("success", true);
				response.put("message", "Login successful");
				return response;
			} else {
				response.put("success", false);
				response.put("message", "Invalid Password");
				return response;
			}
		}
	}

	public boolean checkAlreadyRegister(Owner owner) {
		List<Owner> l = dao.ownerLogin(owner);
		if (l.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void ownerRegister(Owner owner) {
		dao.ownerRegister(owner);
	}

	public Map<String, Object> tenantLogin(Tenant tenant) {
		Map<String, Object> response = new HashMap<>();

		List<Tenant> s = dao.tenantLogin(tenant);
		if (s.size() == 0) {
			response.put("success", false);
			response.put("message", "Invalid User");
			return response;
		} else {
			if (s.get(0).getEmail().equals(tenant.getEmail())
					&& s.get(0).getPassword().equals(tenant.getPassword())) {
				response.put("success", true);
				response.put("message", "Login successful");
				return response;
			} else {
				response.put("success", false);
				response.put("message", "Invalid Password");
				return response;
			}
		}
	}

	public boolean checkAlreadyRegister(Tenant tenant) {
		List<Tenant> l = dao.tenantLogin(tenant);
		if (l.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void tenantRegister(Tenant tenant) {
		dao.tenantRegister(tenant);
	}

	public Tenant getTenant(String email) {
		
		return dao.getTenant(email);
	}

	public Owner getOwner(String email) {
		return dao.getOwner(email);
	}
}
