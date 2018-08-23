package testDao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.yexin.netclass.dao.TeacherDao;
import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Teacher;
import test.TestBase;

public class TestTeacherDao extends TestBase {
	
	private TeacherDao teacherDao;
	@Before
	public void init(){
		teacherDao = super.getContext().getBean("teacherDao",TeacherDao.class);		
	}
	
	@Test
	public void testFindTeacherById() {
		Teacher teacher = teacherDao.findTeacherById("teacher");
		System.out.println(teacher);
	}
	
	@Test
	public void testAddCourse() {
		Course course = new Course();
		course.setCourse_id("15");
		course.setCourse_name("15小学英语");
		course.setCourse_teacher_id("teacher");
		course.setCourse_notice("15小学的英语");
		int i = teacherDao.addCourse(course);
		System.out.println(i);
	}
	
	@Test
	public void testListCourse() {
		List<Course> list = teacherDao.listCourse("teacher");
		System.out.println(list);
	}
	//[Course [class_id=111, class_name=大学物理, class_teacher_id=teacher, class_notice=很难],
	//Course [class_id=12, class_name=英语, class_teacher_id=teacher, class_notice=大学英语], 
	//Course [class_id=13, class_name=小学英语, class_teacher_id=teacher, class_notice=小学的英语], 
	//Course [class_id=a7c9f00d-5dbf-4589-b937-42c429ee68fb, class_name=奥数, class_teacher_id=teacher, class_notice=...],
	//Course [class_id=a82bc743-1292-4126-9172-067323e5ff12, class_name=体育, class_teacher_id=teacher, class_notice=锻炼圣体]]
	
	@Test
	public void testDeleteCourse() {
		int i = teacherDao.deleteCourse("79e75f41-a9bf-41cf-b5f1-531a3463365d");
		System.out.println(i);
	}
	
	@Test
	public void testUpdateCourse() {
		Course course = new Course();
		course.setCourse_notice("新的公告222");
		course.setCourse_id("weqdaadwqeq2131312");
		int i = teacherDao.updateCourse(course);
		System.out.println(i);
	}
	
	@Test
	public void testChangeTeacherInfo() {
		Teacher teacher = new Teacher();
		teacher.setTeacher_signature_line("我的新签名");
		teacher.setTeacher_id("teacher");
		int i = teacherDao.changeTeacherInfo(teacher);
		System.out.println(i);
	}
	
	@Test
	public void testLosdRecord() {
		String receiverId = "tea";
		String courseId = "ef13ed43-dd57-473b-9b28-fd76be91aaa8";
		List<Record> list = teacherDao.loadMessage(courseId,receiverId);
		for (Record record : list) {
			System.out.println(record.getRecord_deliver_name()+record.getRecord_receiver_name()+record.getRecord_message());
			System.out.println(record.getRecord_time());
		}
	}
}
