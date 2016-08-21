package haust.vk.runnabledemo;

class MyThreadDemo implements Runnable{
	public String name;
	
	public MyThreadDemo(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"�������У�"+i);
			
		}
	}
}

class MyThreadDemo1 implements Runnable{
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"�������У�"+i);
			if(i==5){
				try {
					new Thread(this,"����").join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

public class RDemo4 {
	public static void main(String[] args) {
		
		MyThreadDemo t1 = new MyThreadDemo("����");
		MyThreadDemo1 t2 = new MyThreadDemo1();
		MyThreadDemo1 t3 = new MyThreadDemo1();
		MyThreadDemo t4 = new MyThreadDemo("����sadsdsd");
		
			t4.run();
			t3.run();
			t2.run();
			t1.run();
	}
}
