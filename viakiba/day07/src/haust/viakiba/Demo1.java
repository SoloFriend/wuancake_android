package haust.viakiba;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Demo1 {
	//����һ��SAXParser����
	public static void main(String[] args) throws Exception{
		SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
		parser.parse(new File("./src/contact.xml"),new MyDefaultHandler1());
	}
	
}
