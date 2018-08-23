package cn.yexin.netclass.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yexin.netclass.pojo.Admin;
import cn.yexin.netclass.pojo.Student;
import cn.yexin.netclass.pojo.Teacher;
import cn.yexin.netclass.service.AdminService;
import cn.yexin.netclass.service.StudentService;
import cn.yexin.netclass.service.TeacherService;
import cn.yexin.netclass.util.Result;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Resource
    private AdminService adminService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private StudentService studentService;

    @RequestMapping("/login.do")
    @ResponseBody
    public Result execute(String userId, String password, String userType) {
        System.out.println(userId + "," + password + "," + userType);
        if (userType.equals("admin")) {
            Result<Admin> result = new Result<Admin>();
            result = adminService.findAdmin(userId, password);
            System.out.println(result.toString());
            return result;
        } else if (userType.equals("teacher")) {
            Result<Teacher> result = new Result<Teacher>();
            result = teacherService.FindTeacher(userId, password);
            System.out.println(result.getData().getTeacher_name());
            return result;
        } else if (userType.equals("student")) {
            Result<Student> result = new Result<Student>();
            result = studentService.findStudent(userId, password);
            return result;
        } else {
            Result result = new Result();
            result.setStatus(0);
            result.setMsg("登录失败");
            return result;
        }
    }
}
