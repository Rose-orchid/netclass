package cn.yexin.netclass.service;

import java.util.List;

import cn.yexin.netclass.pojo.Courseware;

public interface CoursewareService {

    String uploadCourseware(String wareName, String wareDescribe, String wareTeacher, String wareCourse);

    List<Courseware> listCourseware(String teacherName, String courseName);
}
