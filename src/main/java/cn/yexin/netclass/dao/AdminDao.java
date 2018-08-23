package cn.yexin.netclass.dao;

import cn.yexin.netclass.pojo.Admin;
import cn.yexin.netclass.pojo.Teacher;

import java.util.List;

public interface AdminDao {

    Admin findAdminById(String adminId);

    void registerAdmin(Admin admin);

    int addTeacher(Teacher teacher);

    List<Teacher> listTeacher();

    int deleteTeacher(String teacherId);

    int updateTeaPwd(Teacher teacher);

}
