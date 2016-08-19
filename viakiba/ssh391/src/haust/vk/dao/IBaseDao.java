package haust.vk.dao;

import java.util.List;

/**
 * ����dao��ͨ�ýӿڶ���
 * Created by viakiba on 2016/8/17.
 */
public interface IBaseDao<T> {
    /**
     * ����
     * @parm emp
     */
    void save(T emp);

    /**
     * ���¶�����Ϣ
     * @parm emp
     */
    void update(T emp);

    /**
     * ��������ɾ��
     * @parm id
     */
    void delete(int id);

    /**
     * ����������ѯ
     * @return
     */
    T findById(int id);

    /**
     * ��ѯȫ��
     * @return
     */
    List<T> getAll();
}
