package haust.vk.charu;

public class EFcharu {
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
		//��Ҫ����n������
		for(int i=0;i<a.length;i++){
		//��ʼ����ָ��
		int temp=a[i];
		int low=0;
		int high=i-1;
		int mid=0;
		//�ҵ�Ŀ��λ��
		while(low<=high){
			mid=(low+high)/2;
			if(temp<a[mid]){
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		//��Ŀ��λ�õ�i֮�������ȫ������һλ����Ŀ��λ�ÿճ���
		for(int j=i-1;j>=low;j--){
			a[j+1]=a[j];
		}
		//���low=i���Ͳ��ý������в����ˣ�ԭ���ǣ���ʼλ����0����һ�β����и�ֵ��
		if(low!=i){
			a[low]=temp;
		}
			}
		}
	}

