package haust.vk.dao;

import haust.vk.entity.Dept;
import haust.vk.utils.HibernateUtils;

public class DeptDao {
	/*
	 * ������ѯ
	 */
	public Dept findById(int id){
		return (Dept) HibernateUtils.getSf().get(Dept.class, id);
	}
}
