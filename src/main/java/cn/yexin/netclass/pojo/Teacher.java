package cn.yexin.netclass.pojo;

import java.io.Serializable;
import java.util.Date;

public class Teacher implements Serializable {

    private String teacher_id;
    private String teacher_name;
    private String teacher_password;
    private String teacher_gender;
    private String teacher_birthday;
    private String teacher_signature_line;

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_password() {
        return teacher_password;
    }

    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }

    public String getTeacher_gender() {
        return teacher_gender;
    }

    public void setTeacher_gender(String teacher_gender) {
        this.teacher_gender = teacher_gender;
    }

    public String getTeacher_birthday() {
        return teacher_birthday;
    }

    public void setTeacher_birthday(String teacher_birthday) {
        this.teacher_birthday = teacher_birthday;
    }

    public String getTeacher_signature_line() {
        return teacher_signature_line;
    }

    public void setTeacher_signature_line(String teacher_signature_line) {
        this.teacher_signature_line = teacher_signature_line;
    }

    @Override
    public String toString() {
        return "Teacher [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", teacher_password="
                + teacher_password + ", teacher_gender=" + teacher_gender + ", teacher_birthday=" + teacher_birthday
                + ", teacher_signature_line=" + teacher_signature_line + "]";
    }

}
