package haust.vk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by viakiba on 2016/8/19.
 */
public class UserInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception{
        //�õ���ǰִ�еķ���
        String methodName = invocation.getProxy().getMethod();
        //�õ�ActionContext����
        ActionContext ac = invocation.getInvocationContext();
        //��ȡsession����session�л�ȡ��¼�Ĺ���Ա�˺�
        Object obj = ac.getSession().get("adminInfo");

        //�ж�
        if(!"login".equals(methodName) && !"list".equals(methodName)){
            //��֤
            if(obj == null){
                //û�е�¼
                return "login";
            }else{
                //ִ��action
                return invocation.invoke();
            }

        }else{
            //������ʵ�¼���б�չʾ
            return invocation.invoke();
        }
    }
}
