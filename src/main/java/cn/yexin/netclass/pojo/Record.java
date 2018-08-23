package cn.yexin.netclass.pojo;

public class Record {
    private String record_id;
    private String record_course_id;
    private String record_deliver_id;
    private String record_deliver_name;
    private String record_receiver_id;
    private String record_receiver_name;
    private String record_message;
    private String record_time;

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public String getRecord_course_id() {
        return record_course_id;
    }

    public void setRecord_course_id(String record_course_id) {
        this.record_course_id = record_course_id;
    }

    public String getRecord_deliver_id() {
        return record_deliver_id;
    }

    public void setRecord_deliver_id(String record_deliver_id) {
        this.record_deliver_id = record_deliver_id;
    }

    public String getRecord_deliver_name() {
        return record_deliver_name;
    }

    public void setRecord_deliver_name(String record_deliver_name) {
        this.record_deliver_name = record_deliver_name;
    }

    public String getRecord_receiver_id() {
        return record_receiver_id;
    }

    public void setRecord_receiver_id(String record_receiver_id) {
        this.record_receiver_id = record_receiver_id;
    }

    public String getRecord_receiver_name() {
        return record_receiver_name;
    }

    public void setRecord_receiver_name(String record_receiver_name) {
        this.record_receiver_name = record_receiver_name;
    }

    public String getRecord_message() {
        return record_message;
    }

    public void setRecord_message(String record_message) {
        this.record_message = record_message;
    }

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }

    @Override
    public String toString() {
        return "Record [record_id=" + record_id + ", record_course_id=" + record_course_id + ", record_deliver_id="
                + record_deliver_id + ", record_deliver_name=" + record_deliver_name + ", record_receiver_id="
                + record_receiver_id + ", record_receiver_name=" + record_receiver_name + ", record_message="
                + record_message + ", record_time=" + record_time + "]";
    }

}
