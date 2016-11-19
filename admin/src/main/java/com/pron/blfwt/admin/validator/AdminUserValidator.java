package  com.pron.blfwt.admin.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pron.blfwt.admin.model.AdminUserVO;
import com.pron.blfwt.admin.utils.Constants;
import com.pron.blfwt.admin.utils.Messages;

public class AdminUserValidator implements Validator {

	@Override
	public boolean supports(Class<?> obj) {
		return  AdminUserVO.class.equals(obj);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, Constants.PARAM_EMAIL, Messages.MESSAGE_EMAIL_EMPTY);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, Constants.PARAM_PASSWORD, Messages.MESSAGE_PASSWORD_EMPTY);
		
		AdminUserVO adminUserVo = (AdminUserVO)target;

		if(!errors.hasErrors() && adminUserVo.getEmail().length() > 128){
			errors.rejectValue(Constants.PARAM_EMAIL, Messages.MESSAGE_EMAIL_INVALID);

		}
		if(!errors.hasErrors() && adminUserVo.getPassword().length() > 8){
			errors.rejectValue(Constants.PARAM_PASSWORD, Messages.MESSAGE_PASSWORD_INVALID);
		}
	}
}
