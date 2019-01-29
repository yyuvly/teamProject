package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import domain.DeleteCommand;

public class DeleteCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return DeleteCommand.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
	}
}