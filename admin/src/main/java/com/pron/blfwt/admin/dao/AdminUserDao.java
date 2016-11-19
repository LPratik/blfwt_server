package  com.pron.blfwt.admin.dao;

import com.pron.blfwt.admin.entity.AdminUser;
import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;

public interface AdminUserDao {

	AdminUser getAdminUser(Integer id) throws ManagerDatabaseException;
	
	AdminUser getAdminUser(String email, String password) throws ManagerDatabaseException;
	
	AdminUser updateAdminUser(AdminUser adminUser) throws ManagerDatabaseException;
}

