package haust.vk.provincecity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProvinceCityServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String province = req.getParameter("province");
		//
		System.out.println(province);
		PrintWriter pw = resp.getWriter();
		pw.write("<?xml version='1.0' encoding='UTF-8'?>");
		pw.write("<root>");
		
		if("�㶫".equals(province)){
			pw.write("<city>����</city>");
			pw.write("<city>����</city>");
			pw.write("<city>��ɽ</city>");
		}else if("����".equals(province)){
			pw.write("<city>��ɳ</city>");
			pw.write("<city>����</city>");
			pw.write("<city>��̶</city>");
			pw.write("<city>����</city>");
		}
		
		pw.write("</root>");
		pw.flush();
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String province = req.getParameter("province");
		//
		resp.setContentType("text/xml;charset=UTF-8");
		System.out.println(province);
		PrintWriter pw = resp.getWriter();
		pw.write("<?xml version='1.0' encoding='UTF-8'?>");
		pw.write("<root>");
		
		if("�㶫".equals(province)){
			pw.write("<city>����</city>");
			pw.write("<city>����</city>");
			pw.write("<city>��ɽ</city>");
		}else if("����".equals(province)){
			pw.write("<city>��ɳ</city>");
			pw.write("<city>����</city>");
			pw.write("<city>��̶</city>");
			pw.write("<city>����</city>");
		}
		
		pw.write("</root>");
		pw.flush();
		pw.close();
	}
}
