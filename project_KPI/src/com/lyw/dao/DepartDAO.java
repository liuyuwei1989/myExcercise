package com.lyw.dao;

import java.util.List;

import org.hibernate.Session;

import com.lyw.entity.Depart;

public class DepartDAO {

	public List<Depart> selectAll() {
		Session session = HibernateSessionFactory.getSession();
		@SuppressWarnings("unchecked")
		List<Depart> list = session.createCriteria(Depart.class).list();
		session.close();
		return list;
	}

	public Depart selectById(int departId) {
		Session session = HibernateSessionFactory.getSession();
		Depart depart = (Depart)session.createQuery("from Depart where id = ?").setInteger(0, departId).uniqueResult();
		session.close();
		return depart;
	}

}
