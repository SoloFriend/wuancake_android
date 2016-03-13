package haust.viakiba.dom4j_writer;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
/*
 * �޸�xml����
 * ���ӣ��ĵ�����ǩ ������
 * �޸ģ�����ֵ���ı�
 * ɾ������ǩ������
 * @author viakiba
 * */


public class Dome3 {
	@Test
	public void test() throws Exception{
		/*
		 * �����ĵ�
		 * */
		Document doc=DocumentHelper.createDocument();
		//���ӱ�ǩ
		Element rootEle=doc.addElement("contactlist");
		//���ӱ�ǩ
		Element contact=rootEle.addElement("contact");
		//���ñ�ǩ����
		contact.addAttribute("id", "001");
		//���ñ�ǩ�ı�����
		contact.setText("idshiduosaha");

		
		
		
		
		FileOutputStream out=new FileOutputStream("E:/contact.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(out,format);
		
		writer.write(doc);
		
		writer.close();
	}
	
	/**
	 * �޸ģ�����ֵ���ı�
	 * @throws Exception
	 */
	@Test
	public void test2()	throws Exception{
		Document doc=new SAXReader().read((new File("./src/contact.xml")));
//		Element Ele=doc.getRootElement().element("contact");
//		Attribute attr=Ele.attribute("id");
//		attr.setValue("012");
		
		/**
		 * �������� �޸�����ֵ
		 */
//		Element ele=doc.getRootElement().element("contact");
//		
//		ele.addAttribute("id", "008");
		
		/**
		 * �޸��ı� 1.�õ���ǩ���� 2.�޸��ı�
		 */
		
		Element ele=doc.getRootElement().element("contact").element("name");
		ele.setText("hahaahah");
		
		
		FileOutputStream out=new FileOutputStream("E:/contact.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(out,format);
		
		writer.write(doc);
		
		writer.close();
		
	}
	
	/**
	 * ɾ������ǩ������
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception{
		Document doc = new SAXReader().read("./src/contact.xml");
		
		Element ele=doc.getRootElement().element("contact");
		
		//ele.element("name").detach();
		
		Attribute attr= ele.attribute("id");
		attr.detach();
		
		FileOutputStream out=new FileOutputStream("E:/contact.xml");
		
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(out,format);
		
		writer.write(doc);
		writer.close();
		
	}
}
