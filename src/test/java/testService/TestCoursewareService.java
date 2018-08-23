package testService;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.yexin.netclass.service.CoursewareService;
import test.TestBase;

public class TestCoursewareService extends TestBase {

	private CoursewareService service;
	@Before
	public void init() {
		service = super.getContext().getBean("coursewareService",CoursewareService.class);
	}
	
	@Test
	public void login1() {
		List list = service.listCourseware("叶鑫", "高等数学");
		System.out.println(list);
	}
}
