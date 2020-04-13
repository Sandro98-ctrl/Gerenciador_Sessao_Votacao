package br.com.compasso.gerenciador.exception;

import br.com.compasso.gerenciador.model.Sessao;

public class SessaoNotFoundException extends NotFoundException {

	private static final String defaultMsg = "Sessão não encontrada";
	private static final long serialVersionUID = 1L;

	public SessaoNotFoundException() {
		this(defaultMsg);
	}

	public SessaoNotFoundException(String msg) {
		super(msg, Sessao.class);
	}

}
