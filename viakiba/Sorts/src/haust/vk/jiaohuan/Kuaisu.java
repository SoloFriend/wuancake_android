package haust.vk.jiaohuan;

import org.junit.Test;

public class Kuaisu {
	private static int[] a=new int[]{54,53,25,4,8,7,8,95,14,45};
	public static void main(String[] args) {
		int len=a.length;	
		for(int i=0;i<len;i++){
			System.out.print(a[i]+"  ");
		}
		System.out.println();
		//��0��ʼ
		kuai(0,len-1);
		for(int i=0;i<len;i++){
			System.out.print(a[i]+"  ");
		}
	}
	@Test
	public static  void kuai(int left,int right){
		int i,j,k,l;//k��¼��׼����l���ڽ�����ij����ָ��λ��
		if(left>right){
			return ;
		}
		i=left;//��һ��leftΪ0 ��
		j=right;//��һ��rightΪ9 ��
		k=a[left];//����ǻ�׼��
		while(i!=j){
			//��������ֱ���ҵ�a[j]<k��ʱ������ѭ����j��¼λ�� ǰ��i<j
			while(a[j]>=k && i<j){
				j--;
			}
			//�������ң�ֱ���ҵ�a[j]>k��ʱ������ѭ����i��¼λ�� ǰ��i<j
			while(a[i]<=k && i<j){
				i++;
			}
			//�ҵ�i��j֮���໥����λ�ã�
			if(i<j){
			l=a[i];
			a[i]=a[j];
			a[j]=l;
			}
		}
		//������ɺ󣬰ѵ�һ�������뵽ָ��λ��
		a[left]=a[i];
		a[i]=k;
		//�ݹ�
		kuai(left,i-1);
		kuai(i+1,right);
		
	}
}
