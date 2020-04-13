package br.com.compasso.gerenciador.exception;

public abstract class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final Class<?> className;
	
	public NotFoundException(String msg, Class<?> className) {
		super(msg);
		this.className = className;
	}
	
	public Class<?> getClassName() {
		return className;
	}
}
