package haust.viakiba.f_context;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ServletContext ����Ļ�ȡ
		ServletContext servletPath=this.getServletContext();
		
		//�õ�web��Ӧ��·��
		String str=servletPath.getContextPath();
		System.out.println(str);
		//Ӧ�õ��ض���
		resp.sendRedirect(str+"/index.html");
	}
}
