package testDao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.yexin.netclass.dao.StudentDao;
import cn.yexin.netclass.pojo.Choose;
import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Forum;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Student;
import test.TestBase;

public class TestStudentDao extends TestBase {
	
	private StudentDao studentDao;
	@Before
	public void init(){
		studentDao = super.getContext().getBean("studentDao",StudentDao.class);		
	}
	
	@Test
	public void testFindStudetn() {
		Student student = studentDao.findStudentById("stu");
		System.out.println(student);
	}
	
	@Test
	public void testFindMyClass() {
		List<Choose> list = new ArrayList<Choose>();
		//list = studentDao.findMyCoursesById("student");
		for (Choose choose : list) {
			System.out.print(choose.getCourse().getCourse_name());
			System.out.println(choose.getCourse().getCourse_teacher_name());
		}
	}
	
	@Test
	public void testFindMyClass2() {
		List<Course> list = new ArrayList<Course>();
		list = studentDao.findMyCoursesById2("student");
		for (Course course : list) {
			System.out.print(course.getCourse_name());
			System.out.println(course.getCourse_teacher_name());
		}
	}
	
	@Test
	public void testListAllCourse() {
		List<Course> list = new ArrayList<Course>();
		list = studentDao.listAllCourse("stu");
		for(Course course : list) {
			System.out.print(course.getCourse_name());
			System.out.print(course.getCourse_teacher_name());
			System.out.println(course.getCourse_notice());
		}
	}
	
	@Test
	public void testAddCourse() {
		Choose choose = new Choose();
		choose.setChoose_course_id("15fd269d-e31d-495e-a7e5-04f02e387399");
		choose.setChoose_student_id("student");
		int i = studentDao.chooseCourse(choose);
		System.out.println(i);
	}
	
	@Test
	public void testSendMsg() {
		Record record = new Record();
		record.setRecord_id("2dadqe1233331eqeq");
		record.setRecord_course_id("2");
		record.setRecord_deliver_id("3");
		record.setRecord_deliver_name("4");
		record.setRecord_receiver_id("5");
		record.setRecord_receiver_name("6");
		record.setRecord_message("7");
		int i = studentDao.sendMsg(record);
		System.out.println(i);
	}
	
//	@Test
//	public void testLosdRecord() {
//		String deliverId = "stu";
//		String receiverId = "tea";
//		List<Record> list = studentDao.loadMessage(deliverId, receiverId);
//		for (Record record : list) {
//			System.out.println(record.getRecord_deliver_name()+record.getRecord_receiver_name()+record.getRecord_message());
//			System.out.println(record.getRecord_time());
//		}
//	}
	
	@Test
	public void testSendForum() {
		Forum forum = new Forum();
		forum.setForum_id("2");
		forum.setForum_title("11111");
		forum.setForum_content("123weqeqeqe");
		int i = studentDao.sendForum(forum);
		System.out.println(i);
	}
	
	@Test
	public void testLoadForum() {
		List<Forum> list = studentDao.loadForum("ef13ed43-dd57-473b-9b28-fd76be91aaa8");
		System.out.println(list);
	}
}
