package com.pron.blfwt.admin.utils;

/**
 * Catagorised container of constants
 * @author ochaube
 *
 */
public class Constants {

	/**Parameters***/
	public static final String PARAM_USERNAME = "userName";
	public static final String PARAM_IDS= "userIds";
	public static final String PARAM_PASSWORD = "password";
	public static final String PARAM_NEW_PASSWORD = "newPassword";
	public static final String PARAM_GLOBAL = "global";
	public static final String PARAM_EMAIL= "email";
	public static final String PARAM_ID= "ID";
	public static final String PARAM_USERS = "users";
	
	public static final String PARAM_SCHOOL_ID = "schoolId";
	public static final String PARAM_SCHOOL_CODE = "schoolCode";
	public static final String PARAM_COURSE_ID = "courseId";
	public static final String PARAM_STUDENT_ID = "studentId";
	public static final String PARAM_COURSEVOS = "courseVos";
	
	public static final String PARAM_MEMBER_ID = "memberId";
	public static final String PARAM_MEMBER_NAME = "memberName";
	/**Session & cookie related configurable parameters**/
	public static final int timeOutInterval = 1800;
	public static final String ADMIN_SESSION_ID = "adminSessionId";
	public static final int ADMIN_SESSION_COOKIE_MAX_AGE = 2592000;
	public static final boolean	COOKIE_SECURE = false;

	public static final String EMPTY_STRING = null;
	public static final int COOKIE_EMPTY_STRING_AGE    = 1;
	public static final int SESSION_TIME_INTERVAL = 30;
	
	/** Other constants **/
	public static final String SERVICE_API_URL=Config.getParam("serviecapi.url", "http://localhost:8082/service/api/");
	/** CSV size **/
	public static final Integer SCHOOL_SIZE = 10;
	public static final Integer SUBSCRIPTION_SIZE = 17;
	public static final Integer SCHOOL_SUBSCRIPTION_SIZE = 4;
	public static final Integer USER_STUDENT_SIZE = 6;
	public static final Integer USER_TEACHER_SIZE = 6;
	public static final Integer GROUP_SIZE = 4;
	public static final Integer STUDENT_ENROLLMENT_SIZE = 3;
	public static final Integer TEACHER_ENROLLMENT_SIZE = 3;
	
	public static final String GET_SCHOOLS_URL = SERVICE_API_URL + "schools";
	public static final String HEADER_PARAM = "parameters";
	
	/**
	 * Query Constant
	 */
	public static final String SCHOOLID = "schoolId";
	public static final String SCHOOLCODE = "code";
	public static final String SCHOOLNAME = "name";
	public static final String SCHOOLTENANT = "tenant";
	public static final String SCHOOLLOGO = "logo";
	public static final String COURSENAME="name";
	public static final String COURSELMSNAME="lmsName";
	public static final String COURSESTART="start";
	public static final String COURSEEND="end";
	public static final String COURSEDEADLINE="deadline";
	public static final String COURSECENSUS="censusDate";
	public static final String STUDFIRSTNAME="firstName";
	public static final String STUDLASTNAME="lastName";
	public static final String STUDNUMBER="studentNumber";
	public static final String STUDEMAIL="email";
	public static final String STUDSTATUS="status";
	
	public static final String SCHOOL = "school";
	public static final String COURSE = "course";
	public static final String COURSEID = "courseId";
	public static final String COURSE_DELETED = "course.deleted";
	public static final String SCHOOL_DELETED = "school.deleted";
	public static final String DELETED = "deleted";
	public static final String ID = "id";
	public static final String COURSE_ID = "course.id";
	public static final String ENABLED = "enabled";
	public static final String FRIENDLY_NAME = "friendlyName";
	public static final String DEADLINE = "deadline";
	public static final String END = "end";
	public static final String CENSUS = "censusDate";
	public static final String START = "start";
	public static final String NAME = "name";
	
	public static final String COURSE_ENABLED = "course.enabled";
	public static final String COURSE_FRIENDLY_NAME = "course.friendlyName";
	public static final String COURSE_DEADLINE = "course.deadline";
	public static final String COURSE_END = "course.end";
	public static final String COURSE_CENSUS = "course.censusDate";
	public static final String COURSE_START = "course.start";
	public static final String COURSE_NAME = "course.name";
	public static final String COURSE_COURSEID = "course.courseId";
	public static final String SCHOOL_CODE = "school.code";
	public static final String STUDENT = "student";
	public static final String CREATED = "created";
	public static final String EMAIL = "email";
	public static final String STUDENT_NUMBER = "studentNumber";
	public static final String LAST_NAME = "lastName";
	public static final String FIRST_NAME = "firstName";
	public static final String STUDENT_CREATED = "student.created";
	public static final String STUDENT_EMAIL = "student.email";
	public static final String STUDENT_STUDENT_NUMBER = "student.studentNumber";
	public static final String STUDENT_LAST_NAME = "student.lastName";
	public static final String STUDENT_FIRST_NAME = "student.firstName";
	public static final String STUDENT_ID = "student.id";
	public static final String STUDENT_DELETED = "student.deleted";
	
	public static final String STUDENTA = "studentA";
	public static final String COURSEA = "courseA";
	public static final String STUDENTA_CREATED = "studentA.created";
	public static final String STUDENTA_EMAIL = "studentA.email";
	public static final String STUDENTA_STUDENT_NUMBER = "studentA.studentNumber";
	public static final String STUDENTA_LAST_NAME = "studentA.lastName";
	public static final String STUDENTA_FIRST_NAME = "studentA.firstName";
	public static final String STUDENTA_ID = "studentA.id";
	public static final String COURSEA_ID = "courseA.id";
	public static final String COURSEA_DELETED = "courseA.deleted";
	public static final String STUDENTA_DELETED = "studentA.deleted";
	
	public static final String COURSEA_COURSEID = "courseA.courseId";
	public static final String STUDENT_BC = "studentBc";
	public static final String STUDENTID = "studentId";
	public static final String OPT_IN = "OPT_IN";
	public static final String NOT_FOUND = "NOT_FOUND";
	public static final String OPT_OUT = "OPT_OUT";
	public static final String PARAM_CURRENT_STATUS = "studentCurrentStatus";
	
	
	//Business Center Apis 
	public static final String PARAM_BC_TENANT_ID= "tenant_id";
	public static final String PARAM_BC_COURSE_ID= "course_id";
	
	public static final String GET_TENANT_COURSES ="http://localhost:8088/business_center/tenants/{tenant_id}/courses";
	public static final String GET_TENANT_COURSE_STUDENT ="http://localhost:8088/business_center/tenants/{tenant_id}/courses/{course_id}/users";
	public static final String GET_TENANT ="http://localhost:8088/bc/tenant/200002/";
	
	//Business Center Keys
	public static final String BUSINESS_CENTER_KEY = Config.getParam("business_center_key","THBS6SXTUPZX6R4V");
	public static final String ENVIRONMENT = Config.getParam("env","dev"); 
	public static final String TENANTS = "bc/tenants/"; 
	public static final String COURSES = "bc/tenants/{tenant_id}/courses"; 
	public static final String USERS = "bc/tenants/{tenant_id}/courses/{course_id}/users"; 
	public static final String APIKEY_HEADER = "X-VitalSource-API-Key";
	
}


