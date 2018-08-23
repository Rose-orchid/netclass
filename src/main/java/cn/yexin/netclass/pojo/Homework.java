package cn.yexin.netclass.pojo;

public class Homework {

	private String homework_id;
	private String homework_name;
	private String homework_student_id;
	private String homework_course_id;
	private String homework_time;
	public String getHomework_id() {
		return homework_id;
	}
	public void setHomework_id(String homework_id) {
		this.homework_id = homework_id;
	}
	public String getHomework_name() {
		return homework_name;
	}
	public void setHomework_name(String homework_name) {
		this.homework_name = homework_name;
	}
	public String getHomework_student_id() {
		return homework_student_id;
	}
	public void setHomework_student_id(String homework_student_id) {
		this.homework_student_id = homework_student_id;
	}
	public String getHomework_course_id() {
		return homework_course_id;
	}
	public void setHomework_course_id(String homework_course_id) {
		this.homework_course_id = homework_course_id;
	}
	public String getHomework_time() {
		return homework_time;
	}
	public void setHomework_time(String homework_time) {
		this.homework_time = homework_time;
	}
	@Override
	public String toString() {
		return "Homework [homework_id=" + homework_id + ", homework_name=" + homework_name + ", homework_student_id="
				+ homework_student_id + ", homework_course_id=" + homework_course_id + ", homework_time="
				+ homework_time + "]";
	}
	
}
