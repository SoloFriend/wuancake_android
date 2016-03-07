package haust.viakiba.dom4j_writer;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Demo4 {
	public static void main(String[] args) throws Exception{
		//�����ĵ�
		Document doc=DocumentHelper.createDocument();
		//��������
		Element Students=doc.addElement("Students");
		//����һ���ڵ�
		Element Student=Students.addElement("Student");
		//����һ���ڵ�����
		Student.addAttribute("id", "1");
		//һ���ڵ㴴�������ڵ�
		Element name=Student.addElement("name");
		name.addText("����");
		Element gender=Student.addElement("gender");
		gender.addText("��");
		Element grader=Student.addElement("grade");
		grader.addText("�����һ��");
		Element address=Student.addElement("address");
		address.addText("�������");
		
		//����һ���ڵ�
		Element Student1=Students.addElement("Student");
		//����һ���ڵ�����
		Student1.addAttribute("id", "2");
		Element name1=Student1.addElement("name");
		name1.addText("����");
		Element gender1=Student1.addElement("gender");
		gender1.addText("Ů");
		Element grader1=Student1.addElement("grade");
		grader1.addText("�����2��");
		Element address1=Student1.addElement("address");
		address1.addText("����Խ��");
		
		
		
		//����ĵ�
		FileOutputStream out=new FileOutputStream("E:/contact1.xml");
		
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
	
}
