package testService;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Teacher;
import cn.yexin.netclass.service.TeacherService;
import cn.yexin.netclass.util.Result;
import test.TestBase;

public class TestTeacherService extends TestBase {

	private TeacherService service;
	@Before
	public void init() {
		service = super.getContext().getBean("teacherService",TeacherService.class);
	}
	
	@Test
	public void login1() {
		Result<Teacher> result = service.FindTeacher("teacher", "1234");
		System.out.println(result);
	}
	
	@Test
	public void addCourse(){
		String courseName = "奥数";
		String courseNotice = "...";
		String teacherName = "yelaoshi";
		String teacherId = "teacher";
		Result<Course> result = new Result<Course>();
		result = service.AddCourse(courseName, teacherId, teacherName, courseNotice);
		System.out.println(result);
	}
	
	@Test
	public void listCourse() {
		String teacherId = "teacher";
		Result<List<Course>> result = new Result<List<Course>>();
		result  = service.ListCourse(teacherId);
		for(Course course : result.getData()) {
			System.out.print(course.getCourse_id());
			System.out.println(course.getCourse_name());
		}
	}
	
	@Test
	public void testUpdateNotice() {
		String courseId = "ef13ed43-dd57-473b-9b28-fd76be91aaa8";
		String courseNotice = "更新的公告为:高数老师有事,放假十天!!!!!1!!!!!!!";
		Result<Course> result = service.UpdateCourse(courseId, courseNotice);
		System.out.println(result);
	}
	
	@Test
	public void testLoadMessage() {
		String courseId = "ef13ed43-dd57-473b-9b28-fd76be91aaa8";
		String teacherId = "tea";
		Result<List<Record>> result = new Result<List<Record>>();
		result = service.listMessage(courseId, teacherId);
		System.out.println(result);
	}
}
