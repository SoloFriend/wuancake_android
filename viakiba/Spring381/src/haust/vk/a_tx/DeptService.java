package haust.vk.a_tx;

public class DeptService {
	private DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	/**
	 * �������
	 */
	public void save(Dept dept) {
		//��һ�ε���
		deptDao.save(dept);
		
		//int i = 1/0;
		
		//�ڶ��ε���
		deptDao.save(dept);
	}
}
