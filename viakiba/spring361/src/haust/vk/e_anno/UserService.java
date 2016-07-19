package haust.vk.e_anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//�ѵ�ǰ�������ioc����
//�൱��bean.xml ��<bean id=userService class=".." />��
@Component("userService")
public class UserService {
	
	// ���IOC��������userDao����ע�뵽��ǰ�ֶ�
	/*
	 * <bean id="" class=""> 
	 *	  <property name="userDao" ref="userDao" />    @Resource�൱�����������
	 * </bean>
	 */
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void save(){
		userDao.save();
	}
}
