package com.pron.blfwt.admin.utils;

import java.sql.Timestamp;
import java.util.Date;

import org.dozer.DozerConverter;

public class MemberToMemberDTO extends DozerConverter<Object, Object> {

	public MemberToMemberDTO() {
		super(Object.class, Object.class);
	}
	
	@Override
	public Object convertTo(Object source, Object destination) {
		return null;
	}

	@Override
	public Object convertFrom(Object source, Object destination) {
		if (source != null) {
			 if (source instanceof Date ||source instanceof Timestamp) {
				return Util.convertDateToEpoch((Date)source);
			}
		}
		return null;
	}

}
