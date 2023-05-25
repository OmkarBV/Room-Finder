package com.roomfinder.service;

import java.util.Map;

import com.roomfinder.entity.Owner;
import com.roomfinder.entity.Tenant;

public interface LoginRegister {
	public Map<String, Object> ownerLogin(Owner owner);

	public boolean checkAlreadyRegister(Owner owner);

	public void ownerRegister(Owner owner);

	public Map<String, Object> tenantLogin(Tenant tenant);

	public boolean checkAlreadyRegister(Tenant tenant);

	public void tenantRegister(Tenant tenant);
}
