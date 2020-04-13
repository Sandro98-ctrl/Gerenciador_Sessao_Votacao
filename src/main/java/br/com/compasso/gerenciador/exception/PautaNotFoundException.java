package br.com.compasso.gerenciador.exception;

import br.com.compasso.gerenciador.model.Pauta;

public class PautaNotFoundException extends NotFoundException {

	private static final String defaultMsg = "Pauta não encontrada";
	private static final long serialVersionUID = 1L;

	public PautaNotFoundException() {
		this(defaultMsg);
	}

	public PautaNotFoundException(String msg) {
		super(msg, Pauta.class);
	}

}
