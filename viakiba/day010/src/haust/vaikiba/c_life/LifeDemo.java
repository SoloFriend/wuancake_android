package haust.vaikiba.c_life;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeDemo extends HttpServlet {
	public  LifeDemo() {
		System.out.println("���췽��������");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init����������");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("service������");
	}
	@Override
	public void destroy() {
		System.out.println("������");
	}
	
}
