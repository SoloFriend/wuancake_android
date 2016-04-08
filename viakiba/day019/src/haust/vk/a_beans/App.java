package haust.vk.a_beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;




public class App {
	
	
	//3. ʹ���Դ�����������ת����
		@Test
		public void test3() throws Exception {
			String name="jack3";
			String age="12";
			String brith="1998-08-05";//"1998-08-05" ����Ϊ���ַ�����datelocaleConverter�����������ַ���
			
			Admin admin=new Admin();
			
			//ע������ת����
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			
			BeanUtils.copyProperty(admin, "userName", name);
			BeanUtils.copyProperty(admin, "age", age);
			BeanUtils.copyProperty(admin, "birth", brith);
			
			System.out.println(admin.toString());
		}
		
	//2. �Զ�����������ת����
	@Test
	public void test2() throws Exception {
		String name="jack3";
		String age="12";
		String brith="1998-08-05";
		
		Admin admin=new Admin();
		
		//ע������ת����
		ConvertUtils.register(new Converter(){
			@Override
			//ת��ʹ���ڲ���ķ�������Ҫ��д
			public Object convert(Class type,Object value ){
				if(type!=Date.class){
					return null;
				}
				
				if(value == null || "".equals(value.toString())){
					return null;
				}
				
				try {
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					return sdf.parse(value.toString());
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}	
		}, Date.class);
		
		BeanUtils.copyProperty(admin, "userName", name);
		BeanUtils.copyProperty(admin, "age", age);
		BeanUtils.copyProperty(admin, "birth", brith);
		
		System.out.println(admin.toString());
	}
	
	

	/*
	  	private int id;
		private String userName;
		private String pwd;
		private int age;
		private Date birth; 
	 */
	
	//1. ��javabean�Ļ�������
	@Test
	public void test1() throws Exception{
		//a.��������
		Admin admin=new Admin();
		/*SimpleDateFormat data=new SimpleDateFormat("yyyy-MM-dd");
		Date d=data.get2DigitYearStart();
		admin.setPwd("123");
		admin.setUserName("jack");
		admin.setAge(18);
		admin.setId(1);
		admin.setBirth(d);*/
		
		//b.BeanUtiles���ʵ�ֶ������Եĸ�ֵ
		
		/*BeanUtils.copyProperty(admin, "userName", "jack1");
		BeanUtils.setProperty(admin, "age", 18);*/
		
		// �ܽ�1�� ���ڻ����������ͣ����Զ���������ת��!
		
		//c.����ĸ���
		
		/*Admin newAdmin=new Admin();
		BeanUtils.copyProperties(newAdmin, admin);*/
		
		//d.map���ݣ�������������
		Admin mapAdmin=new Admin();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pwd", "123456");
		map.put("userName", "jack2");
		map.put("age", 18);
		// ע�⣺map�е�keyҪ��javabean����������һ��
		BeanUtils.populate(mapAdmin, map);
		
		System.out.println(mapAdmin.getPwd()+"---"+mapAdmin.getUserName()+"-----"+mapAdmin.getAge());
		
		//System.out.println(admin.getPwd()+"---"+admin.getUserName()+"-----"+admin.getAge());
	}
	
	
}
