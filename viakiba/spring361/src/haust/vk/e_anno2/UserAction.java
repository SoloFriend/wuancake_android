package haust.vk.e_anno2;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

//@Component("userAction")  // ����IOC����

//@Component

@Controller  // ���Ʋ�����
public class UserAction {
	@Resource
	private UserService userService;
	
	public void setUserServicxe(UserService userServicxe) {
		this.userService = userServicxe;
	}
	
	public String execute(){
		userService.save();
		return null;
	}
}
