package cn.yexin.netclass.dao;

import cn.yexin.netclass.pojo.Courseware;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoursewareDao {

    int uploadCourseware(Courseware courseware);

    List<Courseware> listCourseware(@Param("teacherName") String teacherName, @Param("courseName") String courseName);
}
