package haust.viakiba.b_xpath;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dmeo2 {
	public static void main(String[] args) throws Exception{
		//��ȡ�ĵ�
		Document doc=new SAXReader().read("./src/contact.xml");
		//xpath ������ϰ
		String xpath="";
		/**
		 * 1.  	/      ����·��      ��ʾ��xml�ĸ�λ�ÿ�ʼ����Ԫ�أ�һ����νṹ��
		 */
		xpath="/contactlist/contact";
		xpath="//name";
		/**
		 * 2. //     ���·��       ��ʾ�����κβ�νṹ��ѡ��Ԫ�ء�
		 */
		xpath="//age";
		/**
		 * 3. *      ͨ���         ��ʾƥ������Ԫ��
		 */
		xpath="//contact/name";
		xpath="//contact/*";
		/**
		 * 4. []      ����           ��ʾѡ��ʲô�����µ�Ԫ��
		 */
		xpath="/contactList/contact[last()]";
		/**
		 * 5. @     ����            ��ʾѡ�����Խڵ�
		 */
		xpath="//@id";
		/**
		 *6.  text()   ��ʾѡ���ı�����
		 */
		xpath="//contact/name[text()='eric']";
		List<Node> list=doc.selectNodes(xpath);
		for(Node li : list){
			System.out.println(li);
		}
		//�������λ��
		FileOutputStream out=new FileOutputStream("e:/contact.xml");		
		//��������ı�������ʽ
		OutputFormat format=new OutputFormat();
		format.setEncoding("utf-8");
		format.createPrettyPrint();
		//����д���������д��
		XMLWriter writer=new XMLWriter(out,format);
		writer.write(doc);
		//�ر�
		writer.close();
	}
}
