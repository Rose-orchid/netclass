package cn.yexin.netclass.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yexin.netclass.dao.TeacherDao;
import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Notice;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Teacher;
import cn.yexin.netclass.util.Result;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherDao teacherDao;

    public Result<Teacher> FindTeacher(String teacherId, String password) {
        Result<Teacher> result = new Result<Teacher>();
        Teacher teacher = teacherDao.findTeacherById(teacherId);
        if (teacher == null) {
            result.setStatus(0);
            result.setMsg("教师ID不存在");
            return result;
        }

        if (!teacher.getTeacher_password().equals(password)) {
            result.setStatus(0);
            result.setMsg("密码错误");
            return result;
        }

        result.setStatus(2);
        result.setMsg("登录成功");
        result.setData(teacher);
        return result;
    }

    public Result<Course> AddCourse(String courseName, String teacherId, String teacherName, String courseIntro) {
        Result<Course> result = new Result<Course>();
        Course course = new Course();
        course.setCourse_id(UUID.randomUUID().toString());
        course.setCourse_name(courseName);
        course.setCourse_teacher_id(teacherId);
        course.setCourse_teacher_name(teacherName);
        course.setCourse_intro(courseIntro);
        int i = teacherDao.addCourse(course);
        if (i != 1) {
            result.setStatus(0);
            result.setMsg("添加课程失败");
            return result;
        }
        result.setStatus(2);
        result.setMsg("添加课程成功");
        result.setData(course);
        return result;
    }

    public Result<List<Course>> ListCourse(String teacherId) {
        Result<List<Course>> result = new Result<List<Course>>();
        List<Course> list = teacherDao.listCourse(teacherId);
        if (list.size() == 0) {
            result.setStatus(0);
            result.setMsg("加载课程失败");
            return result;
        }
        result.setStatus(2);
        result.setMsg("加载课程成功");
        result.setData(list);
        return result;
    }

    public Result<Course> UpdateCourse(String courseId, String courseNotice) {
        Result<Course> result = new Result<Course>();
        Course course = new Course();

        Notice notice = new Notice();
        notice.setNotice_id(UUID.randomUUID().toString());
        notice.setNotice_course_id(courseId);
        notice.setNotice_content(courseNotice);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = sdf.format(date);
        notice.setNotice_time(time);

        course.setCourse_id(courseId);
        course.setCourse_notice(courseNotice);
        int i = teacherDao.updateCourse(course);
        teacherDao.insertHistoryNotice(notice);
        if (i != 1) {
            result.setStatus(0);
            result.setMsg("更新公告失败");
            return result;
        }
        result.setStatus(i);
        result.setMsg("更新公告成功");
        return result;
    }

    public Result<Course> findCourseById(String courseId) {
        Result<Course> result = new Result<Course>();
        Course course = teacherDao.findCourseById(courseId);
        if (course == null) {
            result.setStatus(0);
            result.setMsg("未找到课程信息");
            return result;
        }
        result.setStatus(2);
        result.setMsg("查询课程信息成功");
        result.setData(course);
        return result;
    }

    public Result<List<Record>> listMessage(String courseId, String teacherId) {
        Result<List<Record>> result = new Result<List<Record>>();
        List<Record> list = teacherDao.loadMessage(courseId, teacherId);
        result.setData(list);
        result.setStatus(1);
        return result;
    }

    public Result<Integer> sendMessage(String courseId, String deliverId, String deliverName, String receiverId,
                                       String receiverName, String msg, String time) {
        Result<Integer> result = new Result<Integer>();
        Record record = new Record();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String newTime = "";
//        try {
//            Date date = sdf.parse(time);
//            date = new Date(date.getTime() + 2000);
//            newTime = sdf.format(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String nowtime = sdf.format(date);
        record.setRecord_id(UUID.randomUUID().toString());
        record.setRecord_course_id(courseId);
        record.setRecord_deliver_id(deliverId);
        record.setRecord_deliver_name(deliverName);
        record.setRecord_receiver_id(receiverId);
        record.setRecord_receiver_name(receiverName);
        record.setRecord_message(msg);
        record.setRecord_time(nowtime);
        int i = teacherDao.sendMsg(record);
        if (i != 1) {
            result.setStatus(0);
            result.setMsg("发送失败");
            return result;
        }
        result.setStatus(i);
        result.setMsg("发送成功");
        return result;
    }

    public Result<Teacher> loadMyInfo(String teacherId) {
        Result<Teacher> result = new Result<Teacher>();
        Teacher teacher = teacherDao.findTeacherById(teacherId);
        result.setStatus(1);
        result.setData(teacher);
        return result;
    }

    public Result<Integer> updateMyInfo(String teacherId, String name, String gender, String birthday,
                                        String signature) {
        Result<Integer> result = new Result<Integer>();
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(teacherId);
        teacher.setTeacher_name(name);
        teacher.setTeacher_gender(gender);
        teacher.setTeacher_birthday(birthday);
        teacher.setTeacher_signature_line(signature);
        int i = teacherDao.updateMyInfo(teacher);
        if (i != 1) {
            result.setStatus(0);
            result.setMsg("更新失败");
            return result;
        }
        result.setStatus(i);
        result.setMsg("更新成功");
        return result;
    }

    public Result<List<Notice>> loadNotice(String courseId) {
        Result<List<Notice>> result = new Result<List<Notice>>();
        List<Notice> list = new ArrayList<Notice>();
        list = teacherDao.loadNotice(courseId);
        result.setData(list);
        result.setMsg("加载成功");
        result.setStatus(1);
        return result;
    }

}
