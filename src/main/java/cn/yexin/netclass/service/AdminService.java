package cn.yexin.netclass.service;

import cn.yexin.netclass.pojo.Admin;
import cn.yexin.netclass.pojo.Teacher;
import cn.yexin.netclass.util.Result;

import java.util.List;

public interface AdminService {

    public Result<Admin> findAdmin(String adminId, String password);

    public Result<Integer> addTeacher(String userId, String username, String password);

    public Result<List<Teacher>> listTeacher();

    public Result<Integer> deleteTeacher(String teacherId);

    public Result<Integer> updateTeaPwd(String teacherId, String password);
}
