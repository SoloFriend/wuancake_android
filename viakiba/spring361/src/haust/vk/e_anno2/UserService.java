package haust.vk.e_anno2;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

//@Component("userService")  // userService����ioc����

//@Component

@Service   // ��ʾҵ���߼�������
public class UserService {
	
	//	@Resource					//  �������Ͳ��� ����������Ҫȷ��������ֻ��һ��������
	
	@Resource(name = "userDao")  // �������Ʋ���
	public UserDao userDao ;
	// IOC������Ĵ�������spring���ⲿ�������
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void save(){
		userDao.save();
	}
}
