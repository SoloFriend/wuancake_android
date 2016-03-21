package haust.vk.dao;

import haust.vk.entiry.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	private static List<Product> data= new ArrayList<Product>();
	
	/*
	 * ��ʼ����Ʒ����
	 */
	static {
		for(int i=0;i<=10;i++){
			data.add(new Product(""+i,"�ʼǱ�"+i,"LN00"+i,34.0+i));
		}
	}
	
	/*
	 * ����������Ʒ
	 */
	public List<Product> findAll(){
		return data;
	}
	
	/*
	 * ���ݱ�Ų�ѯ����
	 */
	
	public Product findByid(String id){
		for(Product p:data){
			if(p.getId().equals(id)){
				return p;
			}
		}
		return null;
	}
}
