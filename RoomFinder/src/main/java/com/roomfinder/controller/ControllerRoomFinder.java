package com.roomfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roomfinder.entity.Owner;
import com.roomfinder.entity.Property;
import com.roomfinder.service.ServiceRoomFinder;

@RestController
@CrossOrigin("http://localhost:4200")
public class ControllerRoomFinder {

	@Autowired
	ServiceRoomFinder service;

	@PostMapping("/insertproperty")
	public String insertProperty(@RequestBody Property property) {
		return service.insertProperty(property);
	}

	@PutMapping("/updatepropertyrent")
	public String updatePropertyRent(@RequestBody Property p) {
		return service.updatePropertyRent(p);
	}

	@DeleteMapping("/deleteproperty")
	public String deleteProperty(@RequestBody Property p) {
		return service.deleteProperty(p);
	}

	@GetMapping("/getallproperty")
	public List<Property> getAllProperty() {

		return service.getAllProperty();
	}

	// Searching the Properties

	@GetMapping("/seachbylocation/{loc}")
	public List<Property> seachByLocation(@PathVariable String loc) {
		return service.seachByLocation(loc);
	}

	@GetMapping("/seachbytype/{roomtype}")
	public List<Property> seachByType(@PathVariable String roomtype) {
		return service.seachByType(roomtype);
	}

	@GetMapping("/searchbyrent/{rent}")
	public List<Property> searchByRent(@PathVariable int rent) {
		return service.searchByRent(rent);
	}

	// Sorting the Property

	@GetMapping("/sortbyrentlowtohigh")
	public List<Property> sortByRentLowToHigh() {
		return service.sortByRentLowToHigh();
	}

	@GetMapping("/sortbyrenthightolow")
	public List<Property> sortByRentHighToLow() {
		return service.sortByRentHighToLow();
	}

	@GetMapping("/getowner/{email}")
	public Owner getOwner(@PathVariable String email) {
		return service.getOwner(email);
	}

}
