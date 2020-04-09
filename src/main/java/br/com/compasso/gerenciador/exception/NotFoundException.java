package br.com.compasso.gerenciador.exception;

public abstract class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final Class<?> classe;
	
	public NotFoundException(String msg, Class<?> classe) {
		super(msg);
		this.classe = classe;
	}
	
	public Class<?> getClasse() {
		return classe;
	}
}
