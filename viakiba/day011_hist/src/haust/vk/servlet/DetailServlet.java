package haust.vk.servlet;

import haust.vk.dao.ProductDao;
import haust.vk.entiry.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		String id=req.getParameter("id");
		
		ProductDao dao=new ProductDao();
		Product product=dao.findByid(id);
		
		PrintWriter writer=resp.getWriter();
		String html="";
		
		html += "<html>";
		html += "<head>";
		html += "<title>��ʾ��Ʒ��ϸ</title>";
		html += "</head>";
		html += "<body>";
		html += "<table border='1' align='center' width='300px'>";
		if(product!=null){
			html += "<tr><th>���:</th><td>"+product.getId()+"</td></tr>";
			html += "<tr><th>��Ʒ����:</th><td>"+product.getProName()+"</td></tr>";
			html += "<tr><th>��Ʒ�ͺ�:</th><td>"+product.getProType()+"</td></tr>";
			html += "<tr><th>��Ʒ�۸�:</th><td>"+product.getPrice()+"</td></tr>";
		}
		
		html += "</table>";
		html += "<center><a href='"+req.getContextPath()+"/ListServlet'>[�����б�]</a></center>";
		html += "</body>";
		html += "</html>";
		
		writer.write(html);
		
		/*
		 * ����cookie
		 */
		Cookie cookie=new Cookie("prodHist",createValue(req,id));
		cookie.setMaxAge(1*30*24*60*60);//һ����
		resp.addCookie(cookie);

		/**
		 * ����cookie��ֵ
		 * ������
		 * 			��ǰcookieֵ                     ������Ʒid               ����cookieֵ
		 *      null��û��prodHist          1                     1    ���㷨�� ֱ�ӷ��ش����id ��
		 *             1                  2                     2,1 ��û���ظ���С��3�����㷨��ֱ�ӰѴ����id����ǰ�� ��
		 *             2,1                1                     1,2�����ظ���С��3�����㷨��ȥ���ظ�id���Ѵ����id����ǰ�� ��
		 *             3,2,1              2                     2,3,1�����ظ���3�����㷨��ȥ���ظ�id���Ѵ����id����ǰ�棩
		 *             3,2,1              4                     4,3,2��û���ظ���3�����㷨��ȥ����id���Ѵ����id����ǰ�棩
		 * @return
		 */
		
	
		
		}
	private String createValue (HttpServletRequest req,String id){
		Cookie[] cookies=req.getCookies();
		String prodHist=null;
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("prodHist")){
					prodHist = cookie.getValue();
					break;
				}
			}
		}
		
		if(cookies==null||prodHist==null){
			return id;
		}
		
		String[] ids=prodHist.split(",");
		
		Collection colls=Arrays.asList(ids);
		
		LinkedList list = new LinkedList(colls);
		
		if(list.size()<3){
			//id�ظ�
			if(list.contains(id)){
				list.remove(id);
				list.addFirst(id);
				
			}else{
				list.addFirst(id);
				
			}
		}else{
			if(list.contains(id)){
				list.remove(id);
				list.addFirst(id);
			}else{
				list.removeLast();
				list.addFirst(id);
			}
		}
		
		StringBuffer sb=new StringBuffer();
		for(Object object:list){
			sb.append(object+",");
		}
		String result=sb.toString();
		result=result.substring(0,result.length()-1);
		return result;
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	}

