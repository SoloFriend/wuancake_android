package haust.vk.charu;

public class Xier {
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

	private static void sorts(int[] a) {
		int d = a.length;
		while(true){//ֱ��d==1
			d = d / 2;
			for(int x=0;x<d;x++){//ȷ��һ�����
				for(int i=x+d;i<a.length;i=i+d){//ȷ��Ŀ�����ֵ
					int item=a[i];//Ŀ�����ֵ��ֵ��item
					int j;//ȷ����Ҫ�Ƚϵ�ֵ��λ��
					for(j=i-d;j>=0&&a[j]>item;j=j-d){
						a[j+d]=a[j];
					}//�����ҵ���Ҫ�����λ�ã�����ִ����һ��j=j-d��
					a[j+d]=item;//������ִ��һ��j+d������Ҫ�����λ��
				}
			}
			if(d == 1){//ȷ������Ҫ�ķ����ִν���
				break;
			}
		 }
		}
	}