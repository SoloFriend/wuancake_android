package haust.vk.d_auto;

public class UserAction {
	// Service: springIOC����ע��
	private UserService userService;
	
	public void setUserServicxe(UserService userServicxe) {
		this.userService = userServicxe;
	}
	
	public String execute(){
		userService.save();
		return null;
	}
}
