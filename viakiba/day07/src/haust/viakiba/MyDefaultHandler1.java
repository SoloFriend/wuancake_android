package haust.viakiba;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler1 extends DefaultHandler {
	
	/*
	 * ��ʼ�ĵ��ǵ���
	 */
	
	@Override
	public void startDocument() throws SAXException{
		System.out.println("MyDefaultHandler1.startDocument");
	}
	/*
	 * @param qName:��ʾ��ʼ��ǩ�ı�ǩ��
	 * @paran attributes:��ʾ��ʼ��ǩ�������б�
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("MyDefaultHandler1.startElement->"+qName);
	}
	/*
	 * @param qName:��ʾ��ʼ��ǩ�ı�ǩ��
	 * */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
	System.out.println("MyDefaultHandler1.endElement->"+qName);	
	}
	
	/*
	 * @param ch:��ʾxml�����ı�����
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str=new String(ch,start,length);
		System.out.println("MyDefaultHandler1.characters->"+str);
	}
	
	/*
	 * �����ĵ��ǵ���
	 */
	@Override
	public void endDocument() throws SAXException{
		System.out.println("MyDefaultHandler1.endDocument");
	}
}
