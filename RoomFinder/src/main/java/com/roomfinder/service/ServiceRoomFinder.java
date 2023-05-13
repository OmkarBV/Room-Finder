package com.roomfinder.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomfinder.dao.DaoRoomFinder;
import com.roomfinder.entity.Owner;
import com.roomfinder.entity.Property;

@Service
public class ServiceRoomFinder {
	@Autowired
	DaoRoomFinder dao;

	public String insertProperty(Property property) {
		return dao.insertProperty(property);
	}

	public List<Property> getAllProperty() {
		return dao.getAllProperty();
	}

	public String updatePropertyRent(Property p) {
		return dao.updatePropertyRent(p);
	}

	public String deleteProperty(Property p) {
		return dao.deleteProperty(p);
	}

	public List<Property> seachByLocation(String loc) {
		return dao.seachByLocation(loc);
	}

	public List<Property> seachByType(String roomtype) {
		return dao.seachByType(roomtype);
	}

	public List<Property> searchByRent(int rent) {
		return dao.searchByRent(rent);
	}

	public List<Property> sortByRentLowToHigh() {
		ArrayList<Property> al = (ArrayList<Property>) dao.sortByRent();
		Comparator<Property> comparator = (p1, p2) -> (int) (p1.getRent() - p2.getRent());
		Collections.sort(al, comparator);
		return al;
	}

	public List<Property> sortByRentHighToLow() {
		ArrayList<Property> al = (ArrayList<Property>) dao.sortByRent();
		Comparator<Property> c = (p1, p2) -> (int) (p2.getRent() - p1.getRent());
		Collections.sort(al, c);
		return al;
	}

	public Owner getOwner(String email) {
		Owner owner = dao.getOwner(email);
		owner.setProperties(dao.getOwnerProperties(owner));
		System.out.println(owner);
		return owner;
	}
}
