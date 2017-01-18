package com.pron.blfwt.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pron.blfwt.admin.dao.MemberDao;
import com.pron.blfwt.admin.dto.MemberDTO;
import com.pron.blfwt.admin.entity.Member;
import com.pron.blfwt.admin.exceptions.ManagerBusinessException;
import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;
import com.pron.blfwt.admin.model.JsonResponse;
import com.pron.blfwt.admin.model.MemberVO;
import com.pron.blfwt.admin.service.AdminMemberService;
import com.pron.blfwt.admin.service.BaseService;
import com.pron.blfwt.admin.utils.Messages;

@Service("adminMemberService")
public class AdminMemberServiceImpl extends BaseService implements AdminMemberService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private Mapper dozerBeanMapper;

	@Override
	@Transactional
	public ResponseEntity<?> addMember(MemberVO memberVo, HttpServletRequest request, HttpServletResponse response)
			throws ManagerDatabaseException, ManagerBusinessException {

		try{
			Member memberExists =  memberDao.getMemberByName(memberVo.getName());
			if(memberExists==null){
				Member member = memberDao.addMember(dozerBeanMapper.map(memberVo, Member.class));
				if(member!=null){
					return ResponseEntity.status(HttpStatus.OK).body(JsonResponse.instance(HttpStatus.OK.value(),
							Messages.MESSAGE_GENERIC_OK, resolveLocalizedMessage(Messages.MESSAGE_GENERIC_OK), null));
				}else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),
									Messages.MESSAGE_MEMBER_NOT_FOUND,
									resolveLocalizedMessage(Messages.MESSAGE_MEMBER_NOT_FOUND), null));
				}

			}else{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),
								Messages.MESSAGE_MEMBER_ALREADY_EXISTS,
								resolveLocalizedMessage(Messages.MESSAGE_MEMBER_ALREADY_EXISTS), null));
			}
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(JsonResponse.instance(HttpStatus.INTERNAL_SERVER_ERROR.value(),
							Messages.MESSAGE_GENERIC_UNEXPECTED_ERROR,
							resolveLocalizedMessage(Messages.MESSAGE_GENERIC_UNEXPECTED_ERROR), null));
		}

	}

	@Override
	public ResponseEntity<?> getAllMembers(HttpServletRequest request, HttpServletResponse response)
			throws ManagerDatabaseException, ManagerBusinessException {
		try{
			List<MemberDTO> memberDtoList = new ArrayList<MemberDTO>(); 
			List<Member> memberList = memberDao.getAllMembers();
			if(!memberList.isEmpty()){
				for(Member member:memberList){
					MemberDTO memberDto = (MemberDTO) dozerBeanMapper.map(member, MemberDTO.class);
					memberDtoList.add(memberDto);
				}
				return ResponseEntity.status(HttpStatus.OK).body(JsonResponse.instance(HttpStatus.OK.value(),
							Messages.MESSAGE_GENERIC_OK, resolveLocalizedMessage(Messages.MESSAGE_GENERIC_OK), memberDtoList));

			}else{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),
								Messages.MESSAGE_MEMBER_NOT_FOUND,
								resolveLocalizedMessage(Messages.MESSAGE_MEMBER_NOT_FOUND), null));
			}
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(JsonResponse.instance(HttpStatus.INTERNAL_SERVER_ERROR.value(),
							Messages.MESSAGE_GENERIC_UNEXPECTED_ERROR,
							resolveLocalizedMessage(Messages.MESSAGE_GENERIC_UNEXPECTED_ERROR), null));
		}
	}

	@Override
	public ResponseEntity<?> getMemberById(String memberId, HttpServletRequest request, HttpServletResponse response)
			throws ManagerDatabaseException, ManagerBusinessException {
		try{
			MemberDTO memberDto = dozerBeanMapper.map(memberDao.getMemberById(Integer.parseInt(memberId)),MemberDTO.class);
			if(memberDto!=null){
				return ResponseEntity.status(HttpStatus.OK).body(JsonResponse.instance(HttpStatus.OK.value(),
							Messages.MESSAGE_GENERIC_OK, resolveLocalizedMessage(Messages.MESSAGE_GENERIC_OK), memberDto));

			}else{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),
								Messages.MESSAGE_MEMBER_NOT_FOUND,
								resolveLocalizedMessage(Messages.MESSAGE_MEMBER_NOT_FOUND), null));
			}
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(JsonResponse.instance(HttpStatus.INTERNAL_SERVER_ERROR.value(),
							Messages.MESSAGE_GENERIC_UNEXPECTED_ERROR,
							resolveLocalizedMessage(Messages.MESSAGE_GENERIC_UNEXPECTED_ERROR), null));
		}
	}

	@Override
	@Transactional
	public ResponseEntity<?> getMemberByName(String memberName, HttpServletRequest request,
			HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException {
		try{
			MemberDTO memberDto = dozerBeanMapper.map(memberDao.getMemberByName(memberName),MemberDTO.class);
			if(memberDto!=null){
				return ResponseEntity.status(HttpStatus.OK).body(JsonResponse.instance(HttpStatus.OK.value(),
							Messages.MESSAGE_GENERIC_OK, resolveLocalizedMessage(Messages.MESSAGE_GENERIC_OK), memberDto));

			}else{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),
								Messages.MESSAGE_MEMBER_NOT_FOUND,
								resolveLocalizedMessage(Messages.MESSAGE_MEMBER_NOT_FOUND), null));
			}
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(JsonResponse.instance(HttpStatus.INTERNAL_SERVER_ERROR.value(),
							Messages.MESSAGE_GENERIC_UNEXPECTED_ERROR,
							resolveLocalizedMessage(Messages.MESSAGE_GENERIC_UNEXPECTED_ERROR), null));
		}
	}

}
