package cn.yexin.netclass.service;

import javax.annotation.Resource;

import cn.yexin.netclass.pojo.Teacher;
import org.springframework.stereotype.Service;

import cn.yexin.netclass.dao.AdminDao;
import cn.yexin.netclass.pojo.Admin;
import cn.yexin.netclass.util.Result;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;

    public Result<Admin> findAdmin(String adminId, String password) {
        Result<Admin> result = new Result<Admin>();
        Admin admin = adminDao.findAdminById(adminId);
        if (admin == null) {
            result.setStatus(0);
            result.setMsg("管理员ID不存在");
            return result;
        }

        if (!admin.getAdmin_password().equals(password)) {
            result.setStatus(0);
            result.setMsg("密码错误");
            return result;
        }

        result.setStatus(3);
        result.setMsg("登录成功");
        result.setData(admin);
        return result;

    }

    public Result<Integer> addTeacher(String userId, String username, String password) {
        Result<Integer> result = new Result<Integer>();
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(userId);
        teacher.setTeacher_name(username);
        teacher.setTeacher_password(password);
        int i = adminDao.addTeacher(teacher);
        if (i == 1) {
            result.setStatus(1);
            result.setMsg("添加成功");
            return result;
        }
        result.setStatus(0);
        result.setMsg("添加失败");
        return result;
    }

    public Result<List<Teacher>> listTeacher() {
        Result<List<Teacher>> result = new Result<List<Teacher>>();
        List<Teacher> list = adminDao.listTeacher();
        result.setData(list);
        result.setStatus(1);
        return result;
    }

    public Result<Integer> deleteTeacher(String teacherId) {
        Result<Integer> result = new Result<Integer>();
        int i = adminDao.deleteTeacher(teacherId);
        if (i != 1) {
            result.setStatus(0);
            result.setMsg("删除失败");
            return result;
        }
        result.setStatus(1);
        result.setMsg("删除成功");
        return result;
    }

    public Result<Integer> updateTeaPwd(String teacherId, String password) {
        Result<Integer> result = new Result<Integer>();
        Teacher teacher = new Teacher();
        teacher.setTeacher_password(password);
        teacher.setTeacher_id(teacherId);
        int i = adminDao.updateTeaPwd(teacher);
        if (i != 1) {
            result.setStatus(0);
            result.setMsg("修改失败");
            return result;
        }
        result.setStatus(1);
        result.setMsg("修改成功");
        return result;
    }
}
