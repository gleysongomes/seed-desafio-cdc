package io.github.gleysongomes.casadocodigo.exception;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 3 pontos

@RestControllerAdvice
public class ValidationErrorHandler {

	private final MessageSource messageSource;

	public ValidationErrorHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ValidationErrorsOutputDto handleValidationError(MethodArgumentNotValidException exception) {
		List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		return buildValidationErrors(globalErrors, fieldErrors);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public ValidationErrorsOutputDto handleValidationError(BindException exception) {
		List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		return buildValidationErrors(globalErrors, fieldErrors);
	}

	// 1 ponto
	private ValidationErrorsOutputDto buildValidationErrors(List<ObjectError> globalErrors,
			List<FieldError> fieldErrors) {
		ValidationErrorsOutputDto validationErrorsOutputDto = new ValidationErrorsOutputDto();

		// 1 ponto
		globalErrors.forEach(error -> validationErrorsOutputDto.addError(getErrorMessage(error)));

		// 1 ponto
		fieldErrors.forEach(error -> {
			String errorMessage = getErrorMessage(error);
			validationErrorsOutputDto.addFieldError(error.getField(), errorMessage);
		});

		return validationErrorsOutputDto;
	}

	private String getErrorMessage(ObjectError error) {
		return messageSource.getMessage(error, LocaleContextHolder.getLocale());
	}
}
