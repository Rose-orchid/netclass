package testDao;

import org.junit.Before;
import org.junit.Test;

import cn.yexin.netclass.dao.AdminDao;
import cn.yexin.netclass.pojo.Admin;
import test.TestBase;

public class TestAdminDao extends TestBase {
	
	private AdminDao adminDao;
	@Before
	public void init(){
		adminDao = super.getContext().getBean("adminDao",AdminDao.class);		
	}
	
	@Test
	public void testAdminDao() {
		Admin admin = adminDao.findAdminById("root");
		System.out.println(admin);
	}
	
	@Test
	public void testRegisterAdmin() {
		Admin admin = new Admin();
		admin.setAdmin_name("yexin");
		admin.setAdmin_password("123");
		adminDao.registerAdmin(admin);
	}
}
