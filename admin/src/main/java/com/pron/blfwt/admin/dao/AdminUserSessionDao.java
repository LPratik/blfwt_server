package  com.pron.blfwt.admin.dao;

import com.pron.blfwt.admin.entity.AdminSession;
import com.pron.blfwt.admin.entity.AdminUser;
import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;

public interface AdminUserSessionDao {

	AdminSession createSession(String sessionId, AdminUser dbAdminUser) throws ManagerDatabaseException;
	AdminSession getSession(String sessionId) throws ManagerDatabaseException;
	boolean deleteSession(AdminSession session) throws ManagerDatabaseException;
	boolean updateSession(AdminSession session);
	
}
