package cn.yexin.netclass.pojo;

public class Forum {
	private String forum_id;
	private String forum_course_id;
	private String forum_user_id;
	private String forum_title;
	private String forum_content;
	private String forum_time;
	public String getForum_id() {
		return forum_id;
	}
	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}
	public String getForum_course_id() {
		return forum_course_id;
	}
	public void setForum_course_id(String forum_course_id) {
		this.forum_course_id = forum_course_id;
	}
	public String getForum_user_id() {
		return forum_user_id;
	}
	public void setForum_user_id(String forum_user_id) {
		this.forum_user_id = forum_user_id;
	}
	public String getForum_title() {
		return forum_title;
	}
	public void setForum_title(String forum_title) {
		this.forum_title = forum_title;
	}
	public String getForum_content() {
		return forum_content;
	}
	public void setForum_content(String forum_content) {
		this.forum_content = forum_content;
	}
	public String getForum_time() {
		return forum_time;
	}
	public void setForum_time(String forum_time) {
		this.forum_time = forum_time;
	}
	@Override
	public String toString() {
		return "Forum [forum_id=" + forum_id + ", forum_course_id=" + forum_course_id + ", forum_user_id="
				+ forum_user_id + ", forum_title=" + forum_title + ", forum_content=" + forum_content + ", forum_time="
				+ forum_time + "]";
	}
	
}
