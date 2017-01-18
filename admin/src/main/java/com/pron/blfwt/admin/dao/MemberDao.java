package com.pron.blfwt.admin.dao;

import java.util.List;

import com.pron.blfwt.admin.entity.Member;

public interface MemberDao {


	public Member getMemberById(Integer memberId);
	public Member getMemberByName(String memberName);
	public Member addMember(Member member);
	public List<Member> getAllMembers();
}
