package cn.yexin.netclass.pojo;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

    private String student_id;
    private String student_name;
    private String student_password;
    private String student_gender;
    private String student_birthday;
    private String student_signature_line;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public String getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(String student_gender) {
        this.student_gender = student_gender;
    }

    public String getStudent_birthday() {
        return student_birthday;
    }

    public void setStudent_birthday(String student_birthday) {
        this.student_birthday = student_birthday;
    }

    public String getStudent_signature_line() {
        return student_signature_line;
    }

    public void setStudent_signature_line(String student_signature_line) {
        this.student_signature_line = student_signature_line;
    }

    @Override
    public String toString() {
        return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_password="
                + student_password + ", student_gender=" + student_gender + ", student_birthday=" + student_birthday
                + ", student_signature_line=" + student_signature_line + "]";
    }

}
