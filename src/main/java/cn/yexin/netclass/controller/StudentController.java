package cn.yexin.netclass.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yexin.netclass.pojo.Course;
import cn.yexin.netclass.pojo.Forum;
import cn.yexin.netclass.pojo.Record;
import cn.yexin.netclass.pojo.Student;
import cn.yexin.netclass.service.StudentService;
import cn.yexin.netclass.util.Result;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/listAllCourse.do")
    @ResponseBody
    public Result<List<Course>> listAllCourse(String studentId) {
        System.out.println("收到一个查询全部课程的请求");
        Result<List<Course>> result = new Result<List<Course>>();
        result = studentService.listAllCourse(studentId);
        System.out.println("请求已处理并返回");
        return result;
    }

    @RequestMapping("/listMyCourse.do")
    @ResponseBody
    public Result<List<Course>> listMyCourse(String studentId) {
        System.out.println("收到一个查询我的课程的请求");
        Result<List<Course>> result = new Result<List<Course>>();
        result = studentService.listMyCourse(studentId);
        System.out.println("请求已处理并返回");
        return result;
    }

    @RequestMapping("/addCourse.do")
    @ResponseBody
    public Result<Integer> addCourse(String courseId, String studentId) {
        System.out.println("收到一条选课请求");
        Result<Integer> result = studentService.addCourse(courseId, studentId);
        System.out.println("请求已处理并返回");
        return result;
    }

    @RequestMapping("/loadCourse.do")
    @ResponseBody
    public Result<Course> execute(String courseId) {
        System.out.println(courseId);
        Result<Course> result = new Result<Course>();
        result = studentService.findCourseById(courseId);
        return result;
    }

    @RequestMapping("/sendMsg.do")
    @ResponseBody
    public Result<Integer> sendMsg(String courseId, String studentId, String studentName, String teacherId,
                                   String teacherName, String message) {
        System.out.println(studentName + "给" + teacherName + "发送信息:" + message);
        Result<Integer> result = new Result<Integer>();
        result = studentService.sendMessage(courseId, studentId, studentName, teacherId, teacherName, message);
        return result;
    }

    @RequestMapping("/loadMessage.do")
    @ResponseBody
    public Result<List<Record>> loadMessage(String courseId, String studentId, String teacherId) {
        Result<List<Record>> result = new Result<List<Record>>();
        result = studentService.listMessage(courseId, studentId, teacherId);
        return result;
    }

    @RequestMapping("/loadMyInfo.do")
    @ResponseBody
    public Result<Student> findTeacher(String studentId) {
        Result<Student> result = new Result<Student>();
        result = studentService.loadMyInfo(studentId);
        return result;
    }

    @RequestMapping("/updateInfo.do")
    @ResponseBody
    public Result<Integer> updateMyInfo(String studentId, String name, String gender, String birthday,
                                        String signature) {
        Result<Integer> result = new Result<Integer>();
        result = studentService.updateMyInfo(studentId, name, gender, birthday, signature);
        return result;
    }
    
    @RequestMapping("/sendForum.do")
    @ResponseBody
    public Result<Integer> sendForum(String courseId,String userId,String title,String content){
    	Result<Integer> result = new Result<Integer>();
    	result = studentService.sendForum(courseId, userId, title, content);
    	return result;
    }
    
    @RequestMapping("/loadForum.do")
    @ResponseBody
    public Result<List<Forum>> loadForum(String courseId){
    	Result<List<Forum>> result = new Result<List<Forum>>();
    	result = studentService.loadForum(courseId);
    	return result;
    }
}
