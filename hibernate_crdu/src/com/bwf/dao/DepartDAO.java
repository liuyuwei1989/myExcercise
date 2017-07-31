package com.bwf.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bwf.entity.Depart;

public class DepartDAO {
	public List<Depart> selectAll(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Depart> list = session.createCriteria(Depart.class).list();
		tr.commit();
		session.close();
		return list;
	}

	public Depart selectById(int id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		Depart depart = (Depart)session.get(Depart.class, id);
		tr.commit();
		session.close();
		return depart;
	}
	
	public void deleteById(int id){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		session.delete((Depart)session.get(Depart.class, id));
		tr.commit();
		session.close();
	}
	
	public List<Depart> selectAllHQL(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		session.createQuery("select from com.bwf.entity.Users");
		return null;
	}
}
