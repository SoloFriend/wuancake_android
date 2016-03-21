package haust.vk.b_resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReaourseDemo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 *  . ����java��������Ŀ¼��java��������������� ��tomcat/binĿ¼��
		 *   ���ۣ� ��web��Ŀ�У� . ������tomcat/binĿ¼�¿�ʼ�����Բ���ʹ���������·����
		 */
		
		
		//��ȡ�ļ�����web��Ŀ�²�Ҫ������ȡ����Ϊ.��ʾ��tomcat/binĿ¼��
		

		
		//��ȡ�ļ�����web��Ŀ�²�Ҫ������ȡ����Ϊ.��ʾ��tomcat/binĿ¼��
		/*File file = new File("./src/db.properties");
		FileInputStream in = new FileInputStream(file);*/
		
		/**
		 * ʹ��webӦ���¼�����Դ�ļ��ķ���
		 */
		/**
		 * 1. getRealPath��ȡ,������Դ�ļ��ľ���·��
		 */
		/*String path=this.getServletContext().getRealPath("/WEB_INF/classes/db.propertues");
		System.out.println(path);
		File file=new File(path);
		FileInputStream in = new FileInputStream(file);*/
		
		/**
		 * 2. getResourceAsStream() �õ���Դ�ļ������ص���������
		 */
		InputStream in = this.getServletContext().getResourceAsStream("/WEB_INF/classes/db.propertues");
		Properties p=new Properties();
		
		p.load(in);
		
		String name=p.getProperty("user");
		String pass=p.getProperty("password");
		
		System.out.println("user"+name);
		System.out.println("password"+pass);
		
		
		
		
	}
}
