package haust.vk.runnabledemo;

class SellDemo implements Runnable{
	private int num = 50;
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
		
				if(num > 0){	
					try {
					//��Ϊ��������ֱ�ӵ���getName()���������Ա���Ҫ��ȡ��ǰ�̡߳�
						new Thread(new SellDemo(),"sa").join();
						System.out.println(Thread.currentThread().getName()+"������"+ num-- +"��Ʊ��");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
	}
}

public class RDemo5 {
	public static void main(String[] args) {
		SellDemo s = new SellDemo();
		new Thread(s,"A").start();
		new Thread(s,"B").start();
		new Thread(s,"C").start();
		new Thread(s,"D").start();
	}
}

