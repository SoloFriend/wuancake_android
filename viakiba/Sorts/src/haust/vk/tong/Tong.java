package haust.vk.tong;

import java.util.Scanner;

public class Tong {
	public static void main(String[] args) {
		int d[]=new int[11];
		//��������
		for(int i=0;i<11;i++){
			d[i]=0;
		}
		System.out.println("������һ��������','����");
		Scanner cin=new Scanner(System.in);
		int n=0;
		String str=cin.next();
		String[] a=str.split(",");
		int[] b=new int[a.length];
		for(int i=0;i<a.length;i++){
			b[i]=Integer.parseInt(a[i]);//b[i]�������
			//System.out.print(b[i]+",");
			d[b[i]]++;
			//System.out.println(d[b[i]]);
		}
		
		//�������
		for(int i=0;i<11;i++){
			for(int m=1;m<=d[i];m++){
				System.out.print(i+",");
			}
		}
		
	}
}
