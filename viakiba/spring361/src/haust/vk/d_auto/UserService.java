package haust.vk.d_auto;

public class UserService {
	public UserDao userDao ;
	// IOC������Ĵ�������spring���ⲿ�������
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void save(){
		userDao.save();
	}
}
