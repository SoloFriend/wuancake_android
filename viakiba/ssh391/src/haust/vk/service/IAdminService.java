package haust.vk.service;

import haust.vk.entity.Admin;

/**
 * ����Աҵ���߼��ӿ�
 * Created by viakiba on 2016/8/18.
 */
public interface IAdminService {
    /**
     * ע��
     */
    void register(Admin admin);
    /**
     * ��¼
     */
    Admin login(Admin admin);
}
