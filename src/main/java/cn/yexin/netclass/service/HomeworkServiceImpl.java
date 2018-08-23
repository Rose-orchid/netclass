package cn.yexin.netclass.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yexin.netclass.dao.HomeworkDao;
import cn.yexin.netclass.pojo.Homework;

@Service("homeworkService")
public class HomeworkServiceImpl implements HomeworkService {

    @Resource
    private HomeworkDao homeworkDao;

    public String uploadHomework(String workName, String studentId, String courseId) {
        Homework hw = new Homework();
        hw.setHomework_id(UUID.randomUUID().toString());
        hw.setHomework_name(workName);
        hw.setHomework_course_id(courseId);
        hw.setHomework_student_id(studentId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = sdf.format(date);
        hw.setHomework_time(time);
        int i = homeworkDao.uploadHomework(hw);
        return "upload " + i + " homework successfully!";
    }

    public List<Homework> listHomework(String studentId, String courseId) {
        List<Homework> list = homeworkDao.listHomework(courseId, studentId);
        return list;
    }

    public List<Homework> listAllHomework(String courseId) {
        List<Homework> list = homeworkDao.listAllHomework(courseId);
        return list;
    }

}
