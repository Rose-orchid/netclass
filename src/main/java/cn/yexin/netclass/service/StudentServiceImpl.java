package cn.yexin.netclass.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yexin.netclass.dao.StudentDao;
import cn.yexin.netclass.pojo.Choose;
import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Forum;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Student;
import cn.yexin.netclass.util.Result;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    public Result<Student> findStudent(String studentId, String password) {
        Result<Student> result = new Result<Student>();
        Student student = studentDao.findStudentById(studentId);
        if (student == null) {
            result.setStatus(0);
            result.setMsg("学生ID不存在");
            return result;
        }

        if (!student.getStudent_password().equals(password)) {
            result.setStatus(0);
            result.setMsg("密码错误");
            return result;
        }

        result.setStatus(1);
        result.setMsg("登录成功");
        result.setData(student);
        return result;

    }

    public Result<Course> findCourseById(String courseId) {
        Result<Course> result = new Result<Course>();
        Course course = studentDao.findCourseById(courseId);
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

    public Result<List<Course>> listAllCourse(String studentId) {
        Result<List<Course>> result = new Result<List<Course>>();
        List<Course> list = new ArrayList<Course>();
        list = studentDao.listAllCourse(studentId);
        result.setData(list);
        result.setStatus(1);
        result.setMsg("查询全部课程成功");
        return result;
    }

    public Result<List<Course>> listMyCourse(String studentId) {
        Result<List<Course>> result = new Result<List<Course>>();
        List<Course> list = new ArrayList<Course>();
        list = studentDao.findMyCoursesById2(studentId);
        result.setData(list);
        result.setStatus(1);
        result.setMsg("查询全部课程成功");
        return result;
    }

    public Result<Integer> addCourse(String courseId, String studentId) {
        Result<Integer> result = new Result<Integer>();
        Choose choose = new Choose();
        choose.setChoose_course_id(courseId);
        choose.setChoose_student_id(studentId);
        int i = studentDao.chooseCourse(choose);
        if (i != 1) {
            result.setStatus(0);
            result.setMsg("选课失败");
            return result;
        }
        result.setStatus(1);
        result.setMsg("选课成功");
        return result;
    }

    public Result<Integer> sendMessage(String courseId, String deliverId, String deliverName, String receiverId,
                                       String receiverName, String msg) {
        Result<Integer> result = new Result<Integer>();
        Record record = new Record();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = sdf.format(date);
        record.setRecord_id(UUID.randomUUID().toString());
        record.setRecord_course_id(courseId);
        record.setRecord_deliver_id(deliverId);
        record.setRecord_deliver_name(deliverName);
        record.setRecord_receiver_id(receiverId);
        record.setRecord_receiver_name(receiverName);
        record.setRecord_message(msg);
        record.setRecord_time(time);
        int i = studentDao.sendMsg(record);
        if (i != 1) {
            result.setStatus(0);
            result.setMsg("发送失败");
            return result;
        }
        result.setStatus(i);
        result.setMsg("发送成功");
        return result;
    }

    public Result<List<Record>> listMessage(String courseId, String studentId, String teacherId) {
        Result<List<Record>> result = new Result<List<Record>>();
        List<Record> list = studentDao.loadMessage(courseId, studentId, teacherId);
        result.setData(list);
        result.setStatus(1);
        return result;
    }

    public Result<Student> loadMyInfo(String studentId) {
        Result<Student> result = new Result<Student>();
        Student student = studentDao.findStudentById(studentId);
        result.setStatus(1);
        result.setData(student);
        return result;
    }

    public Result<Integer> updateMyInfo(String studentId, String name, String gender, String birthday,
                                        String signature) {
        Result<Integer> result = new Result<Integer>();
        Student student = new Student();
        student.setStudent_id(studentId);
        student.setStudent_name(name);
        student.setStudent_gender(gender);
        student.setStudent_birthday(birthday);
        student.setStudent_signature_line(signature);
        int i = studentDao.updateMyInfo(student);
        if (i != 1) {
            result.setStatus(0);
            result.setMsg("更新失败");
            return result;
        }
        result.setStatus(i);
        result.setMsg("更新成功");
        return result;
    }

    public Result<Integer> sendForum(String courseId, String userId, String title, String content) {
        Result<Integer> result = new Result<Integer>();
        Forum forum = new Forum();
        forum.setForum_id(UUID.randomUUID().toString());
        forum.setForum_course_id(courseId);
        forum.setForum_user_id(userId);
        forum.setForum_title(title);
        forum.setForum_content(content);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = sdf.format(date);
        forum.setForum_time(time);
        int i = studentDao.sendForum(forum);
        if (i != 1) {
            result.setData(0);
            result.setMsg("发帖失败");
            return result;
        }
        result.setData(i);
        result.setMsg("发帖成功");
        return result;
    }

    public Result<List<Forum>> loadForum(String courseId) {
        Result<List<Forum>> result = new Result<List<Forum>>();
        List<Forum> list = new ArrayList<Forum>();
        list = studentDao.loadForum(courseId);
        result.setData(list);
        result.setMsg("加载成功");
        result.setStatus(1);
        return result;
    }
}
