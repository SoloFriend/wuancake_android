package haust.vk.e_anno;

import org.springframework.stereotype.Component;

//�ѵ�ǰ�������ioc����
//�൱��bean.xml ��<bean id=userDao class=".." />��
@Component("userDao")
public class UserDao {
	public void save() {
		System.out.println("dao  �����û�");
	}
}
