package cn.yexin.netclass.service;

import java.util.List;

import cn.yexin.netclass.pojo.Homework;

public interface HomeworkService {

    String uploadHomework(String workName, String studentId, String courseId);

    List<Homework> listHomework(String studentId, String courseId);

    List<Homework> listAllHomework(String courseId);
}
