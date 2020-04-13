package br.com.compasso.gerenciador.config.validation;

public class NotFoundDTO {

	private Class<?> className;
	private String error;

	public NotFoundDTO(Class<?> className, String error) {
		this.className = className;
		this.error = error;
	}

	public Class<?> getClassName() {
		return className;
	}

	public String getError() {
		return error;
	}

}
