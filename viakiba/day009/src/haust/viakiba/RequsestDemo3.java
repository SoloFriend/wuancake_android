package haust.viakiba;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequsestDemo3 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//��ȡ����ͷ�� user-agent
		String userAgent = request.getHeader("user-agent");
		System.out.println(userAgent);
		
		//�ж��û�ʹ�õ����������
		if(userAgent.contains("Firefox")){
			response.getWriter().write("������ʹ�û�������");
		}else if(userAgent.contains("Chrome")){
			response.getWriter().write("������ʹ�ùȸ������");
		}else if(userAgent.contains("Trident")){
			response.getWriter().write("������ʹ��IE�����");
		}else{
			response.getWriter().write("������û����������������ʹ�û�������");
		}
	}

}
