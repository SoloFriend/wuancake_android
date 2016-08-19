package haust.vk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import haust.vk.entity.Admin;
import haust.vk.service.IAdminService;

/**
 * Created by viakiba on 2016/8/19.
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
    private Admin admin = new Admin();

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    @Override
    public Admin getModel(){
        return admin;
    }

    //service
    private IAdminService adminService;

    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    //��¼
    public String login(){
        //��¼��֤
        Admin adminInfo = adminService.login(admin);

        //��֤
        if(adminInfo == null){
            //��¼ʧ��
            return "loginFaild";
        }else{
            //��¼�ɹ������浽session
            ActionContext.getContext().getSession().put("adminInfo",adminInfo);
            return "index";
        }


    }
}
