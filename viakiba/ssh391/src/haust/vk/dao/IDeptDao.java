package haust.vk.dao;

import haust.vk.entity.Dept;

import java.util.List;

/**
 * Created by viakiba on 2016/8/17.
 */
public interface IDeptDao {
    /**
     * ��ѯȫ��
     * @return ����ȫ����Ϣ
     */
    List<Dept> getAll();

    /**
     * ����������ѯ
     * @param id ����
     * @return ���ز�ѯ��Ľ��
     */
    Dept findById(int id);
}
