package br.com.compasso.gerenciador.exception;

public class SessaoFechadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SessaoFechadaException(String msg) {
		super(msg);
	}
	
}
