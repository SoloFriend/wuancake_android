package haust.vk.dao;

import haust.vk.entity.Employee;
import haust.vk.utils.PageBean;

/**
 * @author vk
 *
 * 2016��4��15��
 */
/*
 * ���ݷ��ʲ㣬�ӿ����
 */
public interface IEmployeeDao {
	/*
	 * ��ҳ��ѯ���
	 */
	public void getAll(PageBean<Employee> pb);
	/*
	 * ��ѯ�ܼ�¼��
	 */
	public int getTotalCount();
}
