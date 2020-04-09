package br.com.compasso.gerenciador.exception;

import br.com.compasso.gerenciador.model.Associado;

public class AssociadoNotFoundException extends NotFoundException {

	private static final String defaultMsg = "Associado não encontrado";
	private static final long serialVersionUID = 1L;

	public AssociadoNotFoundException() {
		this(defaultMsg);
	}

	public AssociadoNotFoundException(String msg) {
		super(msg, Associado.class);
	}

}
