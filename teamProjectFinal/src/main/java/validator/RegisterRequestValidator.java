package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import domain.RegisterRequest;

public class RegisterRequestValidator implements Validator{
	
	private static final String emailRegExp =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	
	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	@Override
	public boolean supports(Class<?> arg0) {
		return RegisterRequest.class.isAssignableFrom(arg0);
		/*
		 * 스프링 MVC에서 전달받은 객체를 자동으로 검증할 경우 올바르게 구현해야 함
		 * 현재 실습에서는 사용하지 않음
		 */
	}
	@Override
	public void validate(Object target, Errors errors) {
		//target : 검사 대상 객체
		//errors : 검사 결과 에러코드를 저장하는 객체
		RegisterRequest regReq = (RegisterRequest) target;
		if(regReq.getId() == null || regReq.getId().trim().isEmpty()) {
			errors.rejectValue("id", "blank");
		} else {
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad.email");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		if(!regReq.getPassword().isEmpty()) {
			if(!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "notEqualPassword");
			}
		}
	}
}