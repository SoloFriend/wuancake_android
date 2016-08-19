package haust.vk.service;

import haust.vk.entity.Employee;

import java.util.List;

/**
 * Ա��ģ��ҵ���߼���ӿ�
 * Created by viakiba on 2016/8/18.
 */
public interface IEmployeeService {
    /**
     * ����
     */
    void save(Employee emp);

    /**
     * ����
     */
    void update(Employee emp);

    /**
     * ����������ѯ
     */
    Employee findById(int id);

    /**
     * ��ѯȫ��
     */
    List<Employee> getAll();

    /**
     *
     */
    List<Employee> getAll(String empName);
    /**
     * ��������ɾ��
     */
    void delete(int id);

    /**
     * ɾ�����Ա��
     */
    void deleteMany(int[] ids);
}
