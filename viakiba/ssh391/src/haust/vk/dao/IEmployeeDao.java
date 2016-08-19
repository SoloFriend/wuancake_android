package haust.vk.dao;

import haust.vk.entity.Employee;

import java.util.List;

/**
 * Ա��ģ��dao�ӿ����
 * Created by viakiba on 2016/8/17.
 */
public interface IEmployeeDao {
    /**
     * ����Ա��
     * @param emp
     */
    void save(Employee emp);

    /**
     * ����Ա����Ϣ
     * @parm Emp
     */
    void update(Employee emp);

    /**
     * ��������ɾ��
     */
    void delete(int id);

    /**
     * ����������ѯ
     * @parm id
     * @return
     */
    Employee findById(int id);

    /**
     * ��ѯȫ��
     * @parm
     * @return
     */
    List<Employee> getAll();
    /**
     * ����Ա������������ѯ
     * @param employeeName
     * @return
     */
    List<Employee> getAll(String employeeName);
}
