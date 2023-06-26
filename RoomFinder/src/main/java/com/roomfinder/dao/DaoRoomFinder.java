package com.roomfinder.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	public boolean insertProperty(Property property) {
		System.out.println(property.getOwner().getId());
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(property);
		tr.commit();
		return true;
	}

	public List<Property> getAllProperty() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Property.class);
		return cri.list();
	}

	public boolean updatePropertyRent(Property p) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(p);
		tr.commit();
		return true;
	}

	public boolean deleteProperty(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(session.get(Property.class, (long) id));
		tr.commit();
		return true;
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

	public Owner getOwner(String email) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Owner.class);
		cri.add(Restrictions.eq("email", email));
		return (Owner) cri.list().get(0);
	}

	public List<Property> getOwnerProperties(Owner owner) {
		Session session = sf.openSession();
		Query<Property> query = session.createQuery("SELECT p FROM Property p JOIN p.owner o WHERE o.id =:owner_id",
				Property.class);
		query.setParameter("owner_id", owner.getId());
		List<Property> l = query.getResultList();
		for (Property p : l) {
			p.setOwner(null);
		}
		return l;
	}

}
