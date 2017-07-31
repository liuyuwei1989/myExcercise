package com.lyw.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bwf.utils.PagingUtils;
import com.lyw.entity.Depart;
import com.lyw.entity.Users;

public class UserDAO {
	@SuppressWarnings("unchecked")
	public List<Users> selectAll(){
		Session session = HibernateSessionFactory.getSession();
		List<Users> list = session.createCriteria(Users.class).list();
		session.close();
		return list;
	}
	
	public void insert(Users user){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		session.save(user);
		tr.commit();
		session.close();
	}

	public Users selectById(int id) {
		Session session = HibernateSessionFactory.getSession();
		Users user = (Users)session.createQuery("from Users where id = ?").setInteger(0, id).uniqueResult();
		session.close();
		return user;
	}

	public void update(Users user) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		session.update(user);
		tr.commit();
		session.close();
	}

	public void deletById(Users user) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		session.delete(user);
		tr.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public void QueryByPage(PagingUtils pagingUtils){
		Session session = HibernateSessionFactory.getSession();
		int page = pagingUtils.getPage();
		int rowsPerPage = pagingUtils.getRowsPerPage();
		int totalRows = (Integer)session.createQuery("select count(*) from Users").uniqueResult();
		pagingUtils.setTotalRows(totalRows);
		pagingUtils.setUserList(session.createCriteria(Users.class).setFirstResult(rowsPerPage*(page-1)).setMaxResults(rowsPerPage).list());
	}
}
