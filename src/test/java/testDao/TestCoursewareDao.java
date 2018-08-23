package testDao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.yexin.netclass.dao.CoursewareDao;
import cn.yexin.netclass.pojo.Courseware;
import test.TestBase;

public class TestCoursewareDao extends TestBase {
	
	private CoursewareDao coursewareDao;
	@Before
	public void init(){
		coursewareDao = super.getContext().getBean("coursewareDao",CoursewareDao.class);		
	}
	
	@Test
	public void loadCourseware() {
		Courseware cw = new Courseware();
		cw.setCourseware_id("2");
		cw.setCourseware_describe("adasdadasda");
		int i = coursewareDao.uploadCourseware(cw);
		System.out.println(i);
	}
	
	@Test
	public void listCourseware() {
		String courseName="高等数学";
		String teacherName = "叶鑫";
		List<Courseware> list = coursewareDao.listCourseware(teacherName, courseName);
		System.out.println(list);
	}
}
