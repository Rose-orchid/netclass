package cn.yexin.netclass.pojo;

import java.io.Serializable;

public class Courseware  implements Serializable {

	private String courseware_id;
	private String courseware_name;
	private String courseware_teacher;
	private String courseware_course;
	private String courseware_describe;
	private String courseware_time;
	public String getCourseware_id() {
		return courseware_id;
	}
	public void setCourseware_id(String courseware_id) {
		this.courseware_id = courseware_id;
	}
	public String getCourseware_name() {
		return courseware_name;
	}
	public void setCourseware_name(String courseware_name) {
		this.courseware_name = courseware_name;
	}
	public String getCourseware_teacher() {
		return courseware_teacher;
	}
	public void setCourseware_teacher(String courseware_teacher) {
		this.courseware_teacher = courseware_teacher;
	}
	public String getCourseware_course() {
		return courseware_course;
	}
	public void setCourseware_course(String courseware_course) {
		this.courseware_course = courseware_course;
	}
	public String getCourseware_describe() {
		return courseware_describe;
	}
	public void setCourseware_describe(String courseware_describe) {
		this.courseware_describe = courseware_describe;
	}
	public String getCourseware_time() {
		return courseware_time;
	}
	public void setCourseware_time(String courseware_time) {
		this.courseware_time = courseware_time;
	}
	@Override
	public String toString() {
		return "Courseware [courseware_id=" + courseware_id + ", courseware_name=" + courseware_name
				+ ", courseware_teacher=" + courseware_teacher + ", courseware_course=" + courseware_course
				+ ", courseware_describe=" + courseware_describe + ", courseware_time=" + courseware_time + "]";
	}
	
}
