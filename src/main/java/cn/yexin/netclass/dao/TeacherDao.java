package cn.yexin.netclass.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Forum;
import cn.yexin.netclass.pojo.Notice;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Teacher;

public interface TeacherDao {

    Teacher findTeacherById(String teacherId);

    int updateMyInfo(Teacher teacher);

    Course findCourseById(String courseId);

    int addCourse(Course course);

    int deleteCourse(String courseId);

    List<Course> listCourse(String teacherId);

    int updateCourse(Course course);

    int changeTeacherInfo(Teacher teacher);

    List<Record> loadMessage(@Param("courseId") String courseId, @Param("teacherId") String teacherId);

    int sendMsg(Record record);

    //更新公告时向数据库插入一条历史公告
    int insertHistoryNotice(Notice notice);

    List<Notice> loadNotice(String courseId);
}
