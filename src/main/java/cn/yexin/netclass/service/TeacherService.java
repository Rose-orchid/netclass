package cn.yexin.netclass.service;

import java.util.List;

import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Notice;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Teacher;
import cn.yexin.netclass.util.Result;

public interface TeacherService {

    Result<Teacher> FindTeacher(String teacherId, String password);

    Result<Teacher> loadMyInfo(String teacherId);

    Result<Course> findCourseById(String courseId);

    Result<Course> AddCourse(String courseName, String teacherId, String teacherName, String courseIntro);

    Result<List<Course>> ListCourse(String teacherId);

    Result<Course> UpdateCourse(String courseId, String courseNotice);

    Result<List<Record>> listMessage(String courseId, String teacherId);

    Result<Integer> sendMessage(String courseId, String deliverId, String deliverName, String receiverId, String receiverName, String msg, String time);

    Result<Integer> updateMyInfo(String teacherId, String name, String gender, String birthday, String signature);
    
    Result<List<Notice>> loadNotice(String courseId);
}
