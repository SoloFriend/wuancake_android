package haust.vk.a_path;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���ñ���
		response.setContentType("text/html;charset=utf-8");
		/*
		 * ת��
		 */
		
		//request.getRequestDispatcher("/target.html").forward(request, response);
		
		/*
		 * �����ض���
		 */
		
		//response.sendRedirect("/day011/target.html");
		
		/*
		 * html�ĳ�����
		 */
		
		//response.getWriter().write("<html><head><title>target</title></head><body> <a href='/day11/target.html'>Ŀ������</a> </body>  </html>  ");
		
		/*
		 * html ��form �ύ
		 */
		
		//response.getWriter().write("<html><body><form action='/day011/target.html'> <input type='submit' />  </form></body></html>");
		
		/*
		 * 
		 */
	}
}
