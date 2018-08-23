package cn.yexin.netclass.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yexin.netclass.dao.CoursewareDao;
import cn.yexin.netclass.pojo.Courseware;

@Service("coursewareService")
public class CoursewareServiceImpl implements CoursewareService {

    @Resource
    private CoursewareDao coursewareDao;

    public String uploadCourseware(String wareName, String wareDescribe, String wareTeacher, String wareCourse) {
        Courseware cw = new Courseware();
        cw.setCourseware_id(UUID.randomUUID().toString());
        cw.setCourseware_name(wareName);
        cw.setCourseware_describe(wareDescribe);
        cw.setCourseware_teacher(wareTeacher);
        cw.setCourseware_course(wareCourse);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = sdf.format(date);
        cw.setCourseware_time(time);
        int i = coursewareDao.uploadCourseware(cw);
        return "upload " + i + " courseware successfully!";
    }

    public List<Courseware> listCourseware(String teacherName, String courseName) {
        List<Courseware> list = coursewareDao.listCourseware(teacherName, courseName);
        return list;
    }

}
