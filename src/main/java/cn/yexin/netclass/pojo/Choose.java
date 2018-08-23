package cn.yexin.netclass.pojo;

public class Choose {

    private String choose_id;
    private String choose_course_id;
    private String choose_student_id;

    private Course course;

    public String getChoose_id() {
        return choose_id;
    }

    public void setChoose_id(String choose_id) {
        this.choose_id = choose_id;
    }

    public String getChoose_course_id() {
        return choose_course_id;
    }

    public void setChoose_course_id(String choose_course_id) {
        this.choose_course_id = choose_course_id;
    }

    public String getChoose_student_id() {
        return choose_student_id;
    }

    public void setChoose_student_id(String choose_student_id) {
        this.choose_student_id = choose_student_id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Choose [choose_id=" + choose_id + ", choose_course_id=" + choose_course_id + ", choose_student_id="
                + choose_student_id + ", course=" + course + "]";
    }

}
