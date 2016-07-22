package haust.vk.b_anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptService {
	
	//����dao
	@Resource
	private DeptDao deptDao;
	
	//��־dao
	@Resource
	private LogDao logDao;
	
	/**
	 * �������
	 */
	@Transactional(
			readOnly = false,  // ��д����
			timeout = -1,       // ����ĳ�ʱʱ�䲻����
			noRollbackFor = ArithmeticException.class,  // ������ѧ�쳣���ع�
			isolation = Isolation.DEFAULT,              // ����ĸ��뼶�����ݿ��Ĭ��
			propagation = Propagation.REQUIRED			// ����Ĵ�����Ϊ
	)
	public void save(Dept dept) {
		logDao.insertLog();  // ������־  ���Լ�����һ������
		int i = 1/0;
		deptDao.save(dept);  // ���沿��
	}
}
