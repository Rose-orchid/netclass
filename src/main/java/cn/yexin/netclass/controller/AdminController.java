package cn.yexin.netclass.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yexin.netclass.pojo.Teacher;
import cn.yexin.netclass.service.AdminService;
import cn.yexin.netclass.util.Result;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping("/addTeacher.do")
    @ResponseBody
    public Result<Integer> addTeacher(String userId, String username, String password){
        Result<Integer> result = adminService.addTeacher(userId,username,password);
        return result;
    }

    @RequestMapping("/listTeacher.do")
    @ResponseBody
    public Result<List<Teacher>> listTeacher(){
        Result<List<Teacher>> result = adminService.listTeacher();
        return result;
    }
    @RequestMapping("/deleteTeacher.do")
    @ResponseBody
    public Result<Integer> deleteTeacher(String teacherId){
        Result<Integer> result = adminService.deleteTeacher(teacherId);
        return result;
    }

    @RequestMapping("/updateTeaPwd.do")
    @ResponseBody
    public Result<Integer> updateTeaPwd(String teacherId,String password){
        Result<Integer> result = adminService.updateTeaPwd(teacherId,password);
        return result;
    }
}
