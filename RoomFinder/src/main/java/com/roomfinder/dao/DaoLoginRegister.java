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
import com.roomfinder.entity.Tenant;

@SuppressWarnings({ "deprecation", "unchecked" })
@Repository
public class DaoLoginRegister {

	@Autowired
	SessionFactory sf;

	public List<Owner> ownerLogin(Owner owner) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Owner.class);
		cri.add(Restrictions.eq("email", owner.getEmail()));
		return cri.list();
	}

	public void ownerRegister(Owner owner) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(owner);
		tr.commit();
	}

	public List<Tenant> tenantLogin(Tenant tenant) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Tenant.class);
		cri.add(Restrictions.eq("email", tenant.getEmail()));
		return cri.list();
	}

	public void tenantRegister(Tenant tenant) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(tenant);
		tr.commit();
	}

	public Tenant getTenant(String email) {
		return (Tenant) sf.openSession().createCriteria(Tenant.class).add(Restrictions.eq("email", email)).list()
				.get(0);
	}

	public Owner getOwner(String email) {
		return (Owner) sf.openSession().createCriteria(Owner.class).add(Restrictions.eq("email", email)).list().get(0);
	}

}
