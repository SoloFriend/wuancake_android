package haust.vk.tongxin.ProCoum;
class Person{
	private String name;
	private String sex;
	private Boolean isimpty = Boolean.TRUE;//�ڴ���Ϊ�գ�
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void set(String name,String sex){
		synchronized (this) {
			while(!isimpty.equals(Boolean.TRUE)){//��Ϊ�յĻ��ȴ����������ѣ�
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.name = name;//Ϊ�յĻ������ߴ��죡
			this.sex = sex;
			System.out.println("set");
			isimpty = Boolean.FALSE;//����������޸����ԣ�
			this.notifyAll();
		}
	}
	
	public void get(){
		synchronized (this) {
			while(!isimpty.equals(Boolean.FALSE)){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("����"+getName()+ ",  "+"�Ա�"+getSex()+"get");
			isimpty = Boolean.TRUE;
			this.notifyAll();
		}
	}
}

