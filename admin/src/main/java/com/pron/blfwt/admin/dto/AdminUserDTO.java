package com.pron.blfwt.admin.dto;
/**
 * 
 * @author pladkat
 *
 */
public class AdminUserDTO {
	//private int id;
		private String adminName;
		private String email;
	/*	private String password;*/
		

		/*public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	*/

		public String getEmail() {
			return email;
		}

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		


	/*	public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}*/
}
