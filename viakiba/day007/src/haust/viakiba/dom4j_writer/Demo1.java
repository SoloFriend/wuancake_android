package haust.viakiba.dom4j_writer;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;



public class Demo1 {
	public static void main(String[] args) throws Exception{
		//��ȡxml�ļ����ߴ���
		Document doc=new SAXReader().read(new File("./src/contact.xml"));
		
		//�޸�Document����
		
		//���޸ĺ�Ķ���д��xml�ĵ���
		//1.ָ�������λ��
		FileOutputStream out=new FileOutputStream("e:/contact.xml");
		//����д������
		XMLWriter writer=new XMLWriter(out);
		//д������
		writer.write(doc);
		//�ر���
		writer.close();
	
	
	}
}
