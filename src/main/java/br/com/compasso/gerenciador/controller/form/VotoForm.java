package br.com.compasso.gerenciador.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VotoForm {

	@NotNull
	@NotEmpty
	private String opcaoVoto;
	@NotNull
	@NotEmpty
	private String associadoId;

	public String getOpcaoVoto() {
		return opcaoVoto;
	}

	public String getAssociadoId() {
		return associadoId;
	}
}
