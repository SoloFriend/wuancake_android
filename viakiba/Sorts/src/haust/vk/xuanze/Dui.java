package haust.vk.xuanze;

import java.util.Arrays;

public class Dui {
	public static void main(String[] args) {
		int[] a=new int[]{11,24,1,35,58,56,24};
		System.out.println("����ǰ");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("����");
		System.out.println("=================================");
		int len=a.length;
		//ѭ������
		for(int i=0;i<len-1;i++){
			//����
			buildMaxHeap(a,len-1-i);
			
			//�����Ѷ������һ��Ԫ��
			swap(a,0,len-1-i);
			System.out.println(Arrays.toString(a));
		}
		System.out.println("=================================");
		System.out.println(Arrays.toString(a));
	}
//����
	private static void buildMaxHeap(int[] a, int lastIndex) {
		 //��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ 
		for(int i=(lastIndex-1)/2;i>=0;i--){
			//k���������жϵĽڵ�
			int k=i;
			//�����ǰk�ڵ���ӽڵ���� 
			while(k*2+1<=lastIndex){
				//k�ڵ�����ӽڵ������
				int biggerIndex=2*k+1;
				//���biggerIndexС��lastIndex����biggerIndex+1�����k�ڵ�����ӽڵ����
				if(biggerIndex<lastIndex){
					//������ӽڵ��ֵ�ϴ�	
					if(a[biggerIndex]<a[biggerIndex+1]){
						//biggerIndex���Ǽ�¼�ϴ��ӽڵ������
						biggerIndex++;
					}
				}
				//���k�ڵ��ֵС����ϴ���ӽڵ��ֵ
				if(a[k]<a[biggerIndex]){
					//��������
					swap(a,k,biggerIndex);
					//��biggerIndex����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵ�����������ӽڵ��ֵ
					k=biggerIndex;
				}else{
					break;
				}
			}
		}
	}
//����
	private static void swap(int[] a, int i, int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
