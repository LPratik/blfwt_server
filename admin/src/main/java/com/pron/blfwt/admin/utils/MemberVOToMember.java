package com.pron.blfwt.admin.utils;

import org.dozer.DozerConverter;

public class MemberVOToMember extends DozerConverter<Object, Object> {

	public MemberVOToMember() {
		super(Object.class, Object.class);
	}
	
	@Override
	public Object convertTo(Object source, Object destination) {
		return null;
	}

	@Override
	public Object convertFrom(Object source, Object destination) {
		if (source != null) {
			if (source.toString().matches("\\d+")) {
				return Util.epochToDate(source.toString());
			}
		}
		return null;
	}

}
