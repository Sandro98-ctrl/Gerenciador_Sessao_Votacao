package br.com.compasso.gerenciador.exception;

import br.com.compasso.gerenciador.model.Voto;

public class VotoNotFoundException extends NotFoundException {

	private static final String defaultMsg = "Voto não encontrado";
	private static final long serialVersionUID = 1L;

	public VotoNotFoundException() {
		this(defaultMsg);
	}

	public VotoNotFoundException(String msg) {
		super(msg, Voto.class);
	}
}
