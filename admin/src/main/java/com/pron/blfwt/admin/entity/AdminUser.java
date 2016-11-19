package com.pron.blfwt.admin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the admin_user database table.
 * 
 */
@Entity
@Table(name="admin_user")
public class AdminUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="admin_name")
	private String adminName;

	private Date created;

	private Date deleted;

	private Date updated;
	
	private String email;

	private String password;
	
	//bi-directional many-to-one association to AdminSession
	@OneToMany(mappedBy="adminUser")
	private List<AdminSession> adminSessions;

	public AdminUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public List<AdminSession> getAdminSessions() {
		return this.adminSessions;
	}

	public void setAdminSessions(List<AdminSession> adminSessions) {
		this.adminSessions = adminSessions;
	}

	public AdminSession addAdminSession(AdminSession adminSession) {
		getAdminSessions().add(adminSession);
		adminSession.setAdminUser(this);

		return adminSession;
	}

	public AdminSession removeAdminSession(AdminSession adminSession) {
		getAdminSessions().remove(adminSession);
		adminSession.setAdminUser(null);

		return adminSession;
	}

}