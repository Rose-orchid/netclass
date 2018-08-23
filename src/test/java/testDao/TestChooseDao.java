package testDao;

import org.junit.Before;
import org.junit.Test;

import cn.yexin.netclass.dao.ChooseDao;
import cn.yexin.netclass.pojo.Choose;
import test.TestBase;

public class TestChooseDao extends TestBase {
	
	private ChooseDao chooseDao;
	@Before
	public void init(){
		chooseDao = super.getContext().getBean("chooseDao",ChooseDao.class);		
	}
	
	@Test
	public void testChooseDao() {
		//Choose choose = chooseDao.findCourseById("student");
		//System.out.println(choose);
	}
	
}
