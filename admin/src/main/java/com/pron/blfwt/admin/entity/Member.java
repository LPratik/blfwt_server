package com.pron.blfwt.admin.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the members database table.
 * 
 */
@Entity
@Table(name="members")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="aadhar_no")
	private String aadharNo;

	private String address;

	@Column(name="age_on_date")
	private int ageOnDate;

	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	private Date deleted;

	private String gender;

	@Column(name="member_type")
	private String memberType;

	@Column(name="mobile_no")
	private String mobileNo;

	private String muid;

	private String name;

	private String nationality;

	private String occupation;

	@Column(name="pan_no")
	private String panNo;

	@Column(name="ref_muid")
	private String refMuid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	public Member() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAadharNo() {
		return this.aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAgeOnDate() {
		return this.ageOnDate;
	}

	public void setAgeOnDate(int ageOnDate) {
		this.ageOnDate = ageOnDate;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMemberType() {
		return this.memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMuid() {
		return this.muid;
	}

	public void setMuid(String muid) {
		this.muid = muid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPanNo() {
		return this.panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getRefMuid() {
		return this.refMuid;
	}

	public void setRefMuid(String refMuid) {
		this.refMuid = refMuid;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}