package io.github.gleysongomes.casadocodigo.exception;

// 0 ponto

public class FieldErrorOutputDto {

	private String field;

	private String message;

	public FieldErrorOutputDto(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
