package haust.vk.service;

import haust.vk.entity.Dept;

import java.util.List;

/**
 * ����ģ��ҵ���߼���ӿ�
 * Created by viakiba on 2016/8/18.
 */
public interface IDeptService {
    /**
     * ��ѯȫ��
     * @return ����ȫ����Ϣ
     */
    List<Dept> getAll();

    /**
     * ����������ѯ
     * @parm id
     * @return
     */
    Dept findById(int id);
}
