package haust.viakiba.b_xpath;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


/*
    ����·��      ��ʾ��xml�ĸ�λ�ÿ�ʼ����Ԫ�أ�һ����νṹ��
				//     ���·��       ��ʾ�����κβ�νṹ��ѡ��Ԫ�ء�
				*      ͨ���         ��ʾƥ������Ԫ��
				[]      ����           ��ʾѡ��ʲô�����µ�Ԫ��
				@     ����            ��ʾѡ�����Խڵ�
				and     ��ϵ          ��ʾ���������ϵ���ȼ���&&��
				text()    �ı�           ��ʾѡ���ı�����
 */
public class Demo1 {
	public static void main(String[] args) throws Exception{
		Document doc=new SAXReader().read(new File("./src/contact.xml"));
		
		Element ele=doc.getRootElement();
		Element elem=(Element)doc.selectSingleNode("//*[@id='001']");
		
		elem.detach();
		
		FileOutputStream out=new FileOutputStream("E:/student.xml") ;
		
		OutputFormat format=new OutputFormat();
		format.setEncoding("utf-8");
		format.createPrettyPrint();
		
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
			
	}
	
	
}
