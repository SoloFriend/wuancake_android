package haust.vk.dao;

import haust.vk.entity.Admin;

/**
 * Created by viakiba on 2016/8/17.
 */
public interface IAdminDao {
    /**
     * ����
     * @parm admin ����Ա����
     */
    void save(Admin admin );

    /**
     * ���ݹ���Ա��Ϣ��ѯ
     * @parm admin ����Ա����
     * @return ���ز�ѯ��Ľ��
     */
    Admin findByAdmin(Admin admin);
}
