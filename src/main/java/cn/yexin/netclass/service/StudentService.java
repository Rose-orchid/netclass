package cn.yexin.netclass.service;

import java.util.List;

import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Forum;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Student;
import cn.yexin.netclass.util.Result;

public interface StudentService {

    Result<Student> findStudent(String studentId, String password);

    Result<Student> loadMyInfo(String studentId);

    Result<Course> findCourseById(String courseId);

    Result<List<Course>> listAllCourse(String studentId);

    Result<List<Course>> listMyCourse(String studentId);

    Result<Integer> addCourse(String courseId, String studentId);

    Result<Integer> sendMessage(String courseId, String deliverId, String deliverName, String receiverId, String receiverName, String msg);

    Result<List<Record>> listMessage(String courseId, String studentId, String teacherId);

    Result<Integer> updateMyInfo(String studentId, String name, String gender, String birthday, String signature);
    
    Result<Integer> sendForum(String courseId,String userId,String title,String content);
    
    Result<List<Forum>> loadForum(String courseId);
}
