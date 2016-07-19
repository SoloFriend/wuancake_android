package haust.vk.e_anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("userAction")
public class UserAction {
	// Service: springIOC����ע��
	
	@Resource(name="userService")
	private UserService userService;
	
	public void setUserServicxe(UserService userServicxe) {
		this.userService = userServicxe;
	}
	
	public String execute(){
		userService.save();
		return null;
	}
}
