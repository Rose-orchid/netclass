package cn.yexin.netclass.pojo;

import java.io.Serializable;

public class Course implements Serializable {

    private String course_id;
    private String course_name;
    private String course_teacher_id;
    private String course_teacher_name;
    private String course_intro;
    private String course_notice;

    public String getCourse_intro() {
        return course_intro;
    }

    public void setCourse_intro(String course_intro) {
        this.course_intro = course_intro;
    }

    public String getCourse_teacher_name() {
        return course_teacher_name;
    }

    public void setCourse_teacher_name(String course_teacher_name) {
        this.course_teacher_name = course_teacher_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_teacher_id() {
        return course_teacher_id;
    }

    public void setCourse_teacher_id(String course_teacher_id) {
        this.course_teacher_id = course_teacher_id;
    }

    public String getCourse_notice() {
        return course_notice;
    }

    public void setCourse_notice(String course_notice) {
        this.course_notice = course_notice;
    }

    @Override
    public String toString() {
        return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_teacher_id="
                + course_teacher_id + ", course_teacher_name=" + course_teacher_name + ", course_intro=" + course_intro
                + ", course_notice=" + course_notice + "]";
    }

}
