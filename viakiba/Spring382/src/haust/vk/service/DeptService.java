package haust.vk.service;

import haust.vk.dao.DeptDao;
import haust.vk.entity.Dept;

import org.hibernate.SessionFactory;

//ҵ���߼���
public class DeptService {
	private DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	public  void save(Dept dept) {
		deptDao.save(dept);
	}
	
}
