package com.bwf.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bwf.dao.HibernateSessionFactory;
import com.bwf.entity.Users;

public class TestQuery {
	private Session session = null;
	
	@Before
	public void before(){
		session=HibernateSessionFactory.getSession();
	}
	
	@After
	public void after(){
		session.close();
	}
	

	public void selectAll(){
		System.out.println("selectAll============");
		String hql = "select name,pwd,email from com.bwf.entity.Users";
		Query query = session.createQuery(hql);
		List<Object[]> objList= query.list();
		for(Object[] objArray : objList){
			for(Object o : objArray){
				System.out.print(o+"====");
			}
			System.out.println();
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		hql = "from com.bwf.entity.Users";
		query = session.createQuery(hql);
		List<Users> userList = query.list();
		for(Users u: userList){
			System.out.println(u.getName()+"==="+u.getPwd()+"==="+u.getEmail());
		}
		System.out.println();
	}
	

	public void selectByName(){
		System.out.println("selectByName===============");
		String hql = "from Users where name='jacks'";
		Query query = session.createQuery(hql);
		Users user = (Users) query.uniqueResult();
		System.out.println(user.getName()+"==="+user.getPwd()+"==="+user.getEmail());
		System.out.println();
	}
	

	public void selectLikeChar(){
		System.out.println("selectLikeChar====================");
		String hql = "from Users where name like 'l%'";
		Query query = session.createQuery(hql);
		List<Users> userList = query.list();
		for(Users u: userList){
			System.out.println(u.getName()+"==="+u.getPwd()+"==="+u.getEmail());
		}
		System.out.println();
	}
	

	public void selectByUsers(){
		System.out.println("selectByUsers====================");
		Users user = new Users();
		user.setName("1");
		String hql = "from Users where name= :user";
		Query query = session.createQuery(hql).setParameter("user", user.getName());
		Users usera = (Users) query.uniqueResult();
		System.out.println(usera.getName()+"==="+usera.getPwd()+"==="+usera.getEmail()+"==="+usera.getDepart().getDepartName());
		System.out.println();
		
	}
	
	
	public void SelectByAge(){
		System.out.println("selectByAge======================");
		String hql = "from Users where age<18";
		Query query = session.createQuery(hql);
		List<Users> userList = query.list();
		for(Users u: userList){
			System.out.println(u.getName()+"==="+u.getPwd()+"==="+u.getAge());
		}
		System.out.println();
		 hql = "from Users where age>18 and sex='女' order by age asc";
		query = session.createQuery(hql);
		userList = query.list();
		for(Users u: userList){
			System.out.println(u.getName()+"==="+u.getPwd()+"==="+u.getSex()+"==="+u.getAge()+u.getDepart().getDepartName());
		}
		System.out.println();
	}
	
	@Test
	public void selectByAgeAndDepart(){
		System.out.println("selectByAgeAndDepart======================");
		String hql  = "from Users where age>20 and depart.departName='生产部'";
		Query query = session.createQuery(hql);
		List<Users> userList = query.list();
		for(Users u: userList){
			System.out.println(u.getName()+"==="+u.getPwd()+"==="+u.getAge()+u.getDepart().getDepartName());
		}
		System.out.println();
	}
	

	public void deleteByname(){
		System.out.println("deleteByname======================");
		String hql = "delete Users where name=:uname";
		Query query = session.createQuery(hql).setParameter("uname", "李明");
		query.executeUpdate();
		System.out.println();
	}
	

	public void select5Result(){
		System.out.println("select5Result======================");
		String hql = "from Users";
		Query query = session.createQuery(hql).setMaxResults(5);
		List<Users> userList = query.list();
		for(Users u: userList){
			System.out.println(u.getName()+"==="+u.getPwd()+"==="+u.getAge()+u.getDepart().getDepartName());
		}
		System.out.println();
	}

	public void select5ResultByAge(){
		System.out.println("select5ResultByAge======================");
		String hql = "from Users order by age asc";
		Query query = session.createQuery(hql).setMaxResults(5);
		List<Users> userList = query.list();
		for(Users u: userList){
			System.out.println(u.getName()+"==="+u.getPwd()+"==="+u.getAge()+u.getDepart().getDepartName());
		}
		System.out.println();
	}
	
	public void changePwdByName(){
		System.out.println("changePwdByName=================");
		Transaction tr = session.beginTransaction();
		String hql = "update Users set pwd=:upwd where name=:uname ";
		Query query = session.createQuery(hql).setParameter("upwd", "123456").setParameter("uname", "李明");
		query.executeUpdate();
		tr.commit();
		System.out.println();
	}
	

	public void deleteLikeChar(){
		System.out.println("deleteLikeChar=================");
		Transaction tr = session.beginTransaction();
		String hql = "delete Users where name like 'l%'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		tr.commit();
		System.out.println();
	}
	
	public void deleteByName(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		String hql = "delete Users where name=:uname";
		session.createQuery(hql).setString("uname", "李明").executeUpdate();
		tr.commit();
		session.close();
	}
}
