package haust.vk.charu;

public class ZJcharu {
	public static void main(String[] args) {
		int[] a=new int[]{11,24,1,35,58,56,24};
		System.out.println("����ǰ");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("����");
		sorts(a);
		System.out.println();
		System.out.println("�����");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("����");
	}

	private static void sorts(int[] a) {//��С�����������
		
		for(int i=1;i<a.length;i++){//��һ��ʼ���Ϳ��Ա�������Ŀ�ָ���쳣��
			//����Ŀ��ֵ
			int item=a[i];
			int j=i-1;
			while(j>=0){
				if(a[j]>item){//���a[j]����Ŀ��ֵ�����a[j]�������ƣ�Ȼ��j--�жϣ����ڵĻ��������ƣ�������������whileѭ��
					a[j+1]=a[j];
					j--;
				}else{
					break;
				}
			}
			a[j+1]=item;//�ҵ��󣬰�item�����ҵ���λ�ü���
			
		}
	}
}
