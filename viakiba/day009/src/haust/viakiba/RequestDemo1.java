package haust.viakiba;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestHeader(request, response);
		
		requestHead(request);
	
	}

	public void requestHead(HttpServletRequest request) {
		/**
		 * 3.2 ����ͷ
		 */
		String host = request.getHeader("Host"); //����ͷ���Ƶĵ�ͷ������
		System.out.println(host);
		
		//������������ͷ
		Enumeration<String> enums = request.getHeaderNames(); //�õ����е�����ͷ�����б�
		while(enums.hasMoreElements()){//�ж��Ƿ�����һ��Ԫ��
			String headerName = enums.nextElement(); //ȡ����һ��Ԫ��
			String headerValue = request.getHeader(headerName);
			System.out.println(headerName+":"+headerValue);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * ����ʵ������
		 */
		InputStream in=request.getInputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=in.read(buf))!=-1){
			String str=new String(buf,0,len);
			System.out.println(str);
		}
	}
	public void requestHang(HttpServletRequest request) {
		/**
		 * 3.1 ������   ��ʽ����GET /day09/hello HTTP/1.1��
		 */
		System.out.println("����ʽ��"+request.getMethod());//����ʽ
		System.out.println("URI:"+request.getRequestURI());//������Դ
		System.out.println("URL:"+request.getRequestURL());
		System.out.println("httpЭ��汾��"+request.getProtocol());//httpЭ��
	}

	public void requestHeader(HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * ����ͷ
		 */
		response.setContentType("text/html");
		String host = request.getHeader("host");
		System.out.println(host);
		
		Enumeration<String> enums=request.getHeaderNames();
		while(enums.hasMoreElements()){
			String headerName=enums.nextElement();
			String headerValue=request.getHeader(headerName);
			System.out.println(headerName+"="+headerValue);
		}
	}

}
