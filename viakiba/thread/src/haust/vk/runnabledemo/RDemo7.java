package haust.vk.runnabledemo;

import java.util.concurrent.locks.ReentrantLock;

class SellDemo3 implements Runnable{
	private int num = 503;
	private final ReentrantLock lock = new ReentrantLock();
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
			lock.lock();
			try{
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
			finally{
				lock.unlock();
			}
		}
	}
public class RDemo7 {
	public static void main(String[] args) {
		SellDemo3 s = new SellDemo3();
		new Thread(s,"A").start();
		new Thread(s,"B").start();
		new Thread(s,"C").start();
	}
}

