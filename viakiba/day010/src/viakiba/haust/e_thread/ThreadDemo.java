package viakiba.haust.e_thread;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadDemo extends HttpServlet {
	int count =0 ;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			resp.setContentType("text/html;charset=utf-8");			
			synchronized (ThreadDemo.class) {//���������Ψһ������ʹ�������
				resp.getWriter().write("�������ǵ�ǰ��վ�ĵ�"+count+"���ÿ�");   //�߳�1ִ����  �� �߳�2ִ��
			}
	}
}
