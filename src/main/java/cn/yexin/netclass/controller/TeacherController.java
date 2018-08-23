package cn.yexin.netclass.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Notice;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Teacher;
import cn.yexin.netclass.service.TeacherService;
import cn.yexin.netclass.util.Result;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @RequestMapping("/addCourse.do")
    @ResponseBody
    public Result<Course> execute(String userId, String teacherName, String className, String classIntro) {
        System.out.println(userId + "," + teacherName + "," + className + "," + classIntro);
        Result<Course> result = new Result<Course>();
        result = teacherService.AddCourse(className, userId, teacherName, classIntro);
        return result;
    }

    @RequestMapping("/loadCourse.do")
    @ResponseBody
    public Result<Course> execute(String courseId) {
        System.out.println(courseId);
        Result<Course> result = new Result<Course>();
        result = teacherService.findCourseById(courseId);
        return result;
    }

    @RequestMapping("/listCourse.do")
    @ResponseBody
    public Result<List<Course>> execute1(String userId) {
        System.out.println(userId);
        Result<List<Course>> result = new Result<List<Course>>();
        result = teacherService.ListCourse(userId);
        return result;
    }

    @RequestMapping("/updateNotice.do")
    @ResponseBody
    public Result<Course> updateNotice(String courseId, String courseNotice) {
        System.out.println("课程ID:" + courseId);
        System.out.println("更新的公告为:" + courseNotice);
        Result<Course> result = teacherService.UpdateCourse(courseId, courseNotice);
        return result;
    }

    @RequestMapping("/loadMessage.do")
    @ResponseBody
    public Result<List<Record>> loadMessage(String courseId, String teacherId) {
        Result<List<Record>> result = new Result<List<Record>>();
        result = teacherService.listMessage(courseId, teacherId);
        return result;
    }

    @RequestMapping("/sendMsg.do")
    @ResponseBody
    public Result<Integer> sendMsg(String courseId, String studentId, String studentName, String teacherId,
                                   String teacherName, String message, String time) {
        System.out.println(teacherName + "给" + studentName + "回信息:" + message + ",时间是:" + time);
        Result<Integer> result = new Result<Integer>();
        result = teacherService.sendMessage(courseId, teacherId, teacherName, studentId, studentName, message, time);
        return result;
    }

    @RequestMapping("/loadMyInfo.do")
    @ResponseBody
    public Result<Teacher> findTeacher(String teacherId) {
        Result<Teacher> result = new Result<Teacher>();
        result = teacherService.loadMyInfo(teacherId);
        return result;
    }

    @RequestMapping("/updateInfo.do")
    @ResponseBody
    public Result<Integer> updateMyInfo(String teacherId, String name, String gender, String birthday,
                                        String signature) {
        Result<Integer> result = new Result<Integer>();
        result = teacherService.updateMyInfo(teacherId, name, gender, birthday, signature);
        return result;
    }

    @RequestMapping("/loadNotice.do")
    @ResponseBody
    public Result<List<Notice>> loadNotice(String courseId) {
        Result<List<Notice>> result = new Result<List<Notice>>();
        result = teacherService.loadNotice(courseId);
        return result;
    }
}
