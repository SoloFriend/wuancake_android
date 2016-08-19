package haust.vk.dao.impl;

import haust.vk.dao.IBaseDao;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by viakiba on 2016/8/17.
 */
public class BaseDao<T> implements IBaseDao<T>{
    //��ǰ������ʵ�ʵ�bean����
    private Class<T> clazz;

    //��ȡ������
    private String className;

    //���䷺��
    public BaseDao(){
        Type  type = this.getClass().getGenericSuperclass();
        //ת��Ϊ����������
        ParameterizedType pt = (ParameterizedType) type;

        //�õ�ʵ������
        Type types[] = pt.getActualTypeArguments();
        //��ȡʵ������
        clazz = (Class<T>) types[0];

        className = clazz.getSimpleName();//��ȡ����
    }

    //����ע��
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    public SessionFactory getSf() {
        return sf;
    }

    @Override
    public void delete(int id){
        sf
                .getCurrentSession()
                .createQuery("delete from "+ className +" where id=? ")
                .setParameter(0, id)
                .executeUpdate();
    }

    @Override
    public void update(T t){
         sf.getCurrentSession().update(t );
    }

    @Override
    public void save(T t){
        sf
                .getCurrentSession()
                .save(t);
    }

    @Override
    public T findById(int id){
        return  (T)sf.getCurrentSession().get(clazz,id);
    }

    @Override
    public List<T> getAll(){
        return sf.getCurrentSession().createQuery("from "+ className).list();
    }
}
