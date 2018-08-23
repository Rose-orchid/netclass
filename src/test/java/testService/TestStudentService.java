package testService;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Student;
import cn.yexin.netclass.service.StudentService;
import cn.yexin.netclass.util.Result;
import test.TestBase;

public class TestStudentService extends TestBase {

	private StudentService service;
	@Before
	public void init() {
		service = super.getContext().getBean("studentService",StudentService.class);
	}
	
	@Test
	public void testLogin() {
		Result<Student> result = service.findStudent("student", "1234");
		System.out.println(result);
	}
	
	@Test
	public void testListAllCourse() {
		Result<List<Course>> result = service.listAllCourse("stu");
		System.out.println(result);
	}
	
	@Test
	public void testListMyCourse() {
		Result<List<Course>> result = service.listMyCourse("student");
		System.out.println(result);
	}
	
	@Test
	public void testSendMsg() {
		Result<Integer> result = service.sendMessage("2313123weqas", "31231", "213dsf", "32143241", "dasfssf", "fafasdfaszvdsdfasfa");
		System.out.println(result);
	}
	
//	@Test
//	public void testLoasMsg() {
//		Result<List<Record>> result = service.listMessage("stu", "tea");
//		List<Record> list = result.getData();
//		for (Record record : list) {
//			System.out.println(record.getRecord_message()+":"+record.getRecord_time());
//		}
//	}
}
