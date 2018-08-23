package cn.yexin.netclass.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yexin.netclass.pojo.Homework;

public interface HomeworkDao {

    int uploadHomework(Homework homework);

    List<Homework> listHomework(@Param("courseId") String courseId, @Param("studentId") String studentId);

    List<Homework> listAllHomework(String courseId);
}
