package haust.vk.runnabledemo;

class SellDemo2 implements Runnable{
	private int num = 503;
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {//һ���������200��
			/*synchronized (this) {
				if(num > 0){	
					try {
					//��Ϊ��������ֱ�ӵ���getName()���������Ա���Ҫ��ȡ��ǰ�̡߳�
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				System.out.println(Thread.currentThread().getName()+"������"+num--+"��Ʊ��");
				}*/
			gen();
			}
		}
	public synchronized  void gen(){
		synchronized (this) {
			if(num > 0){	
				try {
				//��Ϊ��������ֱ�ӵ���getName()���������Ա���Ҫ��ȡ��ǰ�̡߳�
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			System.out.println(Thread.currentThread().getName()+"������"+num--+"��Ʊ��");
			}
	}
}
}
public class RDemo6 {
	public static void main(String[] args) {
		SellDemo2 s = new SellDemo2();
		new Thread(s,"A").start();
		new Thread(s,"B").start();
		new Thread(s,"C").start();
	}
}

