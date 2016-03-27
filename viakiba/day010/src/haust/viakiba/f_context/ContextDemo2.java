package haust.viakiba.f_context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextDemo2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�õ�servletContext����
		ServletContext servletObject=this.getServletContext();
		//��ȡ��Ӧ������������
		System.out.println("����"+servletObject.getInitParameter("BBB"));
		//��ȡ���еĲ���������
	Enumeration<String> enums=servletObject.getInitParameterNames();
	while(enums.hasMoreElements()){
		String name=enums.nextElement();
		String Servletvalue=servletObject.getInitParameter(name);
		System.out.println(name+"="+Servletvalue);
	}
	//���Եõ�ConfigDemo�е�servlet����
	String str=this.getServletConfig().getInitParameter("path");
	System.out.println("path"+"="+str);
	}
}
