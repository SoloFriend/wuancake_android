package haust.vk.threadDemo;

public class TApp1 {
	public static void main(String[] args) {
		long begintion1 = System.currentTimeMillis();
		for(int i=0; i<10000; i++){
			if(i == 50){
				i=i;
			}
		}
		
		long endtime1 = System.currentTimeMillis();
		
		System.out.println(endtime1 - begintion1+"����");		
		long begintion = System.currentTimeMillis();
		for(int i=0; i<10000; i++){
			if(i == 50){
				new TDemo1("����").start();
			}
		}
		
		long endtime = System.currentTimeMillis();
		
		System.out.println(endtime - begintion+"����33");
		

	}
}
