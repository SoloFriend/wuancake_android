package haust.vk.xuanze;

public class JDxuanze {
	public static void main(String[] args) {
		int a[]=new int[]{1,2,5,4,2,36,5,5,333,41,2};
		System.out.println("����ǰ��");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("����");
		System.out.println();
		sorts(a);
		System.out.println("�����");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("����");
	}
	
	//���Ĵ�������
	public static void sorts(int a[]){
		
		for(int i=0;i<a.length;i++){//���ƴ�����ÿһ�Σ���ʼ����λ��ǰ��һλ
			int min=a[i];
			int k=i;
			for(int j=a.length-1;j>=i;j--){//�ҵ���С��һ������
				if(min<a[j]){
					min=a[j];//��¼��С��һ������
					k=j;//��¼��С��һλ���ֵ��½Ǳ�
				}
			}
			a[k]=a[i];
			a[i]=min;
		}
	}
}
