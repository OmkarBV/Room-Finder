package com.roomfinder.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roomfinder.entity.Owner;
import com.roomfinder.entity.Property;

@SuppressWarnings({ "deprecation", "unchecked" })

@Repository
public class DaoRoomFinder {
	@Autowired
	SessionFactory sf;

	public String insertProperty(Property property) {
		System.out.println(property.getOwner().getId());
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(property);
		tr.commit();
		return "Property Inserted";
	}

	public List<Property> getAllProperty() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Property.class);
		return cri.list();
	}

	public Owner ownerProperty(String email) {
			return (Owner) sf.openSession().createCriteria(Owner.class).add(Restrictions.eq("email", email)).list().get(0);
	}

	public String updatePropertyRent(Property p) {
		Session session = sf.openSession();
		Property property = session.get(Property.class, p.getId());
		property.setRent(p.getRent());
		Transaction tri = session.beginTransaction();
		session.save(property);
		tri.commit();
		return "Rent Updated";
	}

	public String deleteProperty(Property p) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Property property = session.get(Property.class, p.getId());
		session.delete(property);
		tr.commit();
		return "Data deleted successfuly";
	}

	public List<Property> seachByLocation(String loc) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Property.class);
		cri.add(Restrictions.eq("location", loc));
		return cri.list();
	}

	public List<Property> seachByType(String roomtype) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Property.class);
		cri.add(Restrictions.eq("type", roomtype));
		System.out.println();
		return cri.list();
	}

	public List<Property> searchByRent(int rent) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Property.class);
		cri.add(Restrictions.le("rent", (double) rent));
		System.out.println();
		return cri.list();
	}

	public List<Property> sortByRent() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Property.class);

		return cri.list();
	}

}
