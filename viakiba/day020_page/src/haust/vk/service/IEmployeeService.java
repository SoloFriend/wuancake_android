package haust.vk.service;

import haust.vk.entity.Employee;
import haust.vk.utils.PageBean;

/**
 * @author vk
 *
 * 2016��4��15��
 */
public interface IEmployeeService {
	/*
	 * ҵ���߼��ӿڲ�
	 */
	public void getAll(PageBean<Employee> pb);
}
