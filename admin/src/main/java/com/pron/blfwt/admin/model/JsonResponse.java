package com.pron.blfwt.admin.model;

import java.util.ArrayList;
import java.util.List;

public class JsonResponse
{
	private int    code;
	private String messageid;
	private String message;
	private Object data;
	private Object metadata;

	private List<ResponseError> errors = new ArrayList<ResponseError>();
	//private Vector<NewCookie> cookies = new Vector<NewCookie>();
	
	public static JsonResponse instance(int code,String messageid, String message)
	{
		return new JsonResponse(code,messageid,message);
	}
	
	public static JsonResponse instance(int code, String messageid,String message, Object data)
	{
		return new JsonResponse(code,messageid,message, data);
	}
	public static JsonResponse instance(int code,String messageid, String message, Object data, Object metadata)
	{
		return new JsonResponse(code,messageid,message,data,metadata);
	}
	
	private JsonResponse(int code, String messageid,String message)
	{
		this.code = code;
		this.message = message;
		this.messageid = messageid;
	}
	private JsonResponse(int code, String messageid,String message, Object data)
	{
		this.code = code;
		this.message = message;
		this.messageid = messageid;
		this.data = data;
	}
	private JsonResponse(int code,String messageid, String message, Object data, Object metadata)
	{
		this.code = code;
		this.message = message;
		this.messageid = messageid;
		this.data = data;
		this.metadata = metadata;
	}
	

	public String getMessageid() {
		return messageid;
	}


	public int getCode()
	{
		return code;
	}
	public String getMessage()
	{
		return message;
	}
	public Object getData()
	{
		return data;
	}
	public Object getMetaData()
	{
		return metadata;
	}
	public void addFieldError(String field,String message)
	{
		errors.add(new FieldError(field,message));
	}
	public List<ResponseError> getErrors()
	{
		return errors;
	}
	
	public abstract class ResponseError
	{
		public abstract String getType();
		public abstract Object getData();
	}
	
	public class FieldError extends ResponseError
	{
		private String type = "fielderror";
		private String field;
		private String message;

		
		public FieldError(String field, String message)
		{
			this.field = field;
			this.message = message;
		}
		public String getType()
		{
			return type;
		}
		public Object getData()
		{
			return data;
		}
		public String getField()
		{
			return this.field;
		}
		public String getMessage()
		{
			return this.message;
		}
	}
}
