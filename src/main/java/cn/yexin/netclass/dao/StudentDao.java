package cn.yexin.netclass.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yexin.netclass.pojo.Choose;
import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Forum;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Student;

public interface StudentDao {

    Student findStudentById(String studentId);

    int updateMyInfo(Student student);

    Course findCourseById(String courseId);

    int chooseCourse(Choose choose);

    //查询的是未选过的课程
    List<Course> listAllCourse(String studentId);

    List<Course> findMyCoursesById2(String studentId);

    int sendMsg(Record record);

    List<Record> loadMessage(@Param("courseId") String courseId, @Param("deliverId") String deliverId, @Param("receiverId") String receiverId);
    
    int sendForum(Forum forum);
    
    List<Forum> loadForum(String courseId);
}
