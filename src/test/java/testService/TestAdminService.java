package testService;

import org.junit.Before;
import org.junit.Test;

import cn.yexin.netclass.pojo.Admin;
import cn.yexin.netclass.service.AdminService;
import cn.yexin.netclass.util.Result;
import test.TestBase;

public class TestAdminService extends TestBase {

	private AdminService service;
	@Before
	public void init() {
		service = super.getContext().getBean("adminService",AdminService.class);
	}
	
	@Test
	public void login1() {
		Result<Admin> result = service.findAdmin("root", "123");
		System.out.println(result);
	}
}
