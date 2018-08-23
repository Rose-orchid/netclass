package cn.yexin.netclass.pojo;

public class Notice {

    private String notice_id;
    private String notice_course_id;
    private String notice_content;
    private String notice_time;

    public String getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(String notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice_course_id() {
        return notice_course_id;
    }

    public void setNotice_course_id(String notice_course_id) {
        this.notice_course_id = notice_course_id;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public String getNotice_time() {
        return notice_time;
    }

    public void setNotice_time(String notice_time) {
        this.notice_time = notice_time;
    }

    @Override
    public String toString() {
        return "Notice [notice_id=" + notice_id + ", notice_course_id=" + notice_course_id + ", notice_content="
                + notice_content + ", notice_time=" + notice_time + "]";
    }

}
