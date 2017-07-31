package com.bwf.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bwf.entity.Users;

public class UserDAO {
	public void insert(Users user) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		session.save(user);
		tr.commit();
		session.close();
	}
	
	public List<Users> selectAll(){
		Session session = HibernateSessionFactory.getSession();
		@SuppressWarnings("unchecked")
		List<Users> list=session.createCriteria(Users.class).list();
		session.close();
		return list;
	}
	
	public void delete(String name){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		session.delete(session.get(Users.class, name));
		tr.commit();
		session.close();
	}
	
	public void saveOrUpdate(Users user){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(user);
		tr.commit();
		session.close();
	}
	
	public Users selectByName(String name){
		Session session = HibernateSessionFactory.getSession();
		Users user=(Users)session.get(Users.class, name);
		session.close();
		return user;
	}
}
