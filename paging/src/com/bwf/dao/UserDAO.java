package com.bwf.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.bwf.entity.Users;

public class UserDAO {

	@SuppressWarnings("unchecked")
	public List<Users> selectAll(int page) {
		Session session = HibernateSessionFactory.getSession();
		List<Users> list = session.createQuery("from Users").setFirstResult(3 * (page - 1)).setMaxResults(3).list();
		session.close();
		return list;
	}

	/**
	 * 根据条件得出搜索条数
	 * @param key_word
	 * @param age_min
	 * @param age_max
	 * @return
	 */
	public int getRows(String key_word, Integer age_min, Integer age_max){
		Session session = HibernateSessionFactory.getSession();
		StringBuilder hql = new StringBuilder("select count(*) from Users where 1=1 ");
		// 根据搜过条件的有无，决定是否添加搜索条件
		if (!"".equals(key_word) && key_word != null) {
			hql.append("and name like '%"+key_word+"%' ");
		}
		if (age_min != 0 && age_min != null) {
			hql.append("and age>="+age_min+" ");
		}
		if (age_max != 0 && age_max != null) {
			hql.append("and age<="+age_max+" ");
		}
		Long rows = (Long)session.createQuery(hql.toString()).uniqueResult();
		return Integer.parseInt(rows.toString());
	}
	/**
	 * 
	 * @param key_word
	 *            搜索关键字
	 * @param age_min
	 *            年龄最小值
	 * @param age_max
	 *            年龄最大值
	 * @param page
	 *            需要被搜索的頁碼
	 * @return 返回搜索结果
	 */
	@SuppressWarnings("unchecked")
	public List<Users> selectByCondition(String key_word, Integer age_min, Integer age_max, Integer rowsPerPage,Integer page) {
		Session session = HibernateSessionFactory.getSession();
		Criteria c = session.createCriteria(Users.class);
		// 根据搜过条件的有无，决定是否添加搜索条件
		if (!"".equals(key_word) && key_word != null) {
			c = c.add(Restrictions.like("name", "%" + key_word + "%"));
		}
		if (age_min != 0 && age_max != null) {
			c = c.add(Restrictions.ge("age", age_min));
		}
		if (age_max != 0 && age_max != null) {
			c = c.add(Restrictions.le("age", age_max));
		}
		List<Users> list = c.setFirstResult(rowsPerPage * (page - 1)).setMaxResults(3).list();
		session.close();
		return list;
	}

}
