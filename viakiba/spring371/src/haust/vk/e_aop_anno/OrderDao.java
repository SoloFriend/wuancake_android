package haust.vk.e_aop_anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Ŀ�����
 * @author viakiba
 *
 */
@Component
@Scope("prototype")
public class OrderDao {
	public void save() {
		System.out.println("===========����ҵ�񣺱��棡����=============");
	}
}
