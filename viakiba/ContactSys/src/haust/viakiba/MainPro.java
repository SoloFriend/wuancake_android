package haust.viakiba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class MainPro {
	public static void main(String[] args) throws Exception{
		
		ContactOperator operater=new ContactOpertorImpl();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true){
			printMenu();
			String curtag=br.readLine();
			if("1".equals(curtag)){
				Contact contact=new Contact();
				System.out.println("�������ţ�");
				String id=br.readLine();

				System.out.println("������������");
				String name=br.readLine();
				
				System.out.println("�������Ա�");
				String gender=br.readLine();
				
				System.out.println("���������䣺");
				String age=br.readLine();
				
				System.out.println("������绰��");
				String phone=br.readLine();
				
				System.out.println("���������䣺");
				String email=br.readLine();
				
				System.out.println("������QQ��");
				String qq=br.readLine();
				
				contact.setId(id);
				contact.setName(name);
				contact.setGender(gender);
				contact.setAge(age+"");
				contact.setPhone(phone);
				contact.setEmail(email);
				contact.setQq(qq);
				
				operater.addContact(contact);
			}
			else if("2".equals(curtag)){
				Contact contact=new Contact();
				//id
				System.out.println("�������޸�id");
				String id=br.readLine();
				//name
				System.out.println("�������޸�name");
				String name=br.readLine();
				//gender
				System.out.println("�������޸�gender");
				String gender=br.readLine();
				//age
				System.out.println("�������޸�age");
				String age=br.readLine();
				//phone
				System.out.println("�������޸�phone");
				String phone=br.readLine();
				//email
				System.out.println("�������޸�email");
				String email=br.readLine();
				//qq
				System.out.println("�������޸�qq");
				String qq=br.readLine();
				
				contact.setId(id);
				contact.setName(name);
				contact.setGender(gender);
				contact.setAge(Integer.parseInt(age)+"");
				contact.setPhone(phone);
				contact.setEmail(email);
				contact.setQq(qq);
				
				operater.updateContact(contact);			
						}
			else if("3".equals(curtag)){
				System.out.println("������ɾ��id");
				String id=br.readLine();	
				operater.deleteContact(id);
			}
			else if("4".equals(curtag)){
				List<Contact> list=operater.findAll();
				for(Contact li:list){
					System.out.println(li.toString());
				}
			}else if("Q".equals(curtag)){
				break;
			}else{
				System.out.println("������������");
			}
			
			}
		}
		
		
	

	private static void printMenu() {
		System.out.println("==================");
		System.out.println("[1]�����ϵ��");
		System.out.println("[2]�޸���ϵ��");
		System.out.println("[3]ɾ����ϵ��");
		System.out.println("[4]��ѯ������ϵ����ϵ��");
		System.out.println("[Q]�����ϵ��");
		System.out.println("==================");
	}
}
