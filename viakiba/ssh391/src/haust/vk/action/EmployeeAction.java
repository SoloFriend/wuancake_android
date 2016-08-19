package haust.vk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import haust.vk.dao.IEmployeeDao;
import haust.vk.entity.Dept;
import haust.vk.entity.Employee;
import haust.vk.service.IDeptService;
import haust.vk.service.IEmployeeService;
import org.apache.struts2.interceptor.RequestAware;

import java.util.List;
import java.util.Map;

/**
 * Ա��ģ�������������
 * 1. Ա���б�չʾ
 * 2. ���Ա��
 * 3. �޸�Ա����Ϣ
 * 5. ɾ��
 * Created by viakiba on 2016/8/19.
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>, RequestAware{
    private Employee employee = new Employee();
    private int deptId;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getDeptId() {
        return deptId;
    }

    @Override
    public Employee getModel(){
        return employee;
    }

    /****** ����ע��Ա�� Service *******/
    private IEmployeeService employeeService;
    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private IDeptService deptService;

    public void setDeptService(IDeptService deptService) {
        this.deptService = deptService;
    }

    private Map<String, Object> request;
    // ���տ������ʱ����Ĵ���request�����map

    @Override
    public void setRequest(Map<String, Object> request){
        this.request = request ;
    }

    /**
     * Ա��չʾ
     */
    public String list(){
        List<Employee> listEmp = employeeService.getAll();

        request.put("listEmp",listEmp);
        return "list";
    }

    //���Ա���������ҳ��
    public String viewAdd(){
        //��ѯ������Ϣ���浽request
        List<Dept> listDept = deptService.getAll();
        request.put("listDept", listDept);
        return "add";
    }

    //���Ա������
    public String save(){
        //�ȸ��ݲ����������в�ѯ
        Dept dept = deptService.findById(deptId);
        //�����õ�Ա��������
        employee.setDept(dept);

        //����service
        employeeService.save(employee);
        return "listAction";
    }

    /**
     * 3.�޸�Ա����Ϣ -- �����޸���ͼ
     */
    public String viewUpdate(){
        //��ȡ��Ҫ�޸ĵļ�¼��id
        int id = employee.getId();

        //����������ѯ
        Employee emp = employeeService.findById(id);

        //��ѯ���еĲ���
        List<Dept> listDept = deptService.getAll();

        //���ݻ���
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.pop();//�Ƴ�ջ��Ԫ��
        vs.push(emp);//��ջ

        //����
        request.put("listDept", listDept);

        return "edit";
    }

    /**
     * 4.�޸�Ա����Ϣ --ȷ���޸�
     */
    public String update(){
        //1. �ȸ��ݲ���id�� ��ѯ���Ŷ���; �����õ�Ա��������
        Dept dept = deptService.findById(deptId);
        employee.setDept(dept);
        //2. ����Ա��
        employeeService.update(employee);
        return "listAction";//�ض����б�
    }

    /**
     * 5.ɾ��Ա����Ϣ
     */
    public String delete(){
        //��ȡԱ��ף����
        int empId = employee.getId();

        //����service ɾ��
        employeeService.delete(empId);
        return "listAction";
    }
}
