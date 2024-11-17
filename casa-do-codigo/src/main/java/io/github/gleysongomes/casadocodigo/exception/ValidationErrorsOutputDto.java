package io.github.gleysongomes.casadocodigo.exception;

import java.util.ArrayList;
import java.util.List;

// 1 ponto

public class ValidationErrorsOutputDto {

	private List<String> globalErrorMessages = new ArrayList<>();

	// 1 ponto
	private List<FieldErrorOutputDto> fieldErrors = new ArrayList<>();

	public void addError(String message) {
		globalErrorMessages.add(message);
	}

	public void addFieldError(String field, String message) {
		FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field, message);
		fieldErrors.add(fieldError);
	}

	public List<String> getGlobalErrorMessages() {
		return globalErrorMessages;
	}

	public void setGlobalErrorMessages(List<String> globalErrorMessages) {
		this.globalErrorMessages = globalErrorMessages;
	}

	public List<FieldErrorOutputDto> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorOutputDto> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
