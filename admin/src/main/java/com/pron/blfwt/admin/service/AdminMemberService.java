package com.pron.blfwt.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.pron.blfwt.admin.exceptions.ManagerBusinessException;
import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;
import com.pron.blfwt.admin.model.MemberVO;

public interface AdminMemberService {

	ResponseEntity<?> addMember(MemberVO memberVo, HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException;
	ResponseEntity<?> getAllMembers(HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException;
	ResponseEntity<?> getMemberById(String memberId,HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException;
	ResponseEntity<?> getMemberByName(String memberName,HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException;
	
}
