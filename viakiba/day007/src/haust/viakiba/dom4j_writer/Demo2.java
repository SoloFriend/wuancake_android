package haust.viakiba.dom4j_writer;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/*
 * д���ĵ���ϸ��
 * */

public class Demo2 {
	public static void main(String[] args) throws Exception{
		//�ĵ���ȡ
		Document doc=new SAXReader().read(new File("./src/contact.xml"));
		
		/*
		 * ָ�������λ��
		 * */
		FileOutputStream out=new FileOutputStream("e:/contact.xml");
		
		/*
		 * ָ�������ʽ
		 * */
		
		//OutputFormat format=OutputFormat.createCompactFormat();
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		//����д������
		XMLWriter writer=new XMLWriter(out,format);
		//д������
		writer.write(doc);
		//�ر������
		writer.close();
	}
}
