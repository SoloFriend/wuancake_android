package haust.vk.e_aop_anno;

import org.springframework.stereotype.Component;

/*
 * ���󱣻�
 */
@Component
public class UserDao implements IUserDao{
	@Override
	public void save() {
		System.out.println("=============����ҵ�񣺱���=======");
	}
}
