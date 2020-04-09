package br.com.compasso.gerenciador.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.compasso.gerenciador.model.OpcaoVoto;

public class VotoFormUseless {

	@NotNull
	private OpcaoVoto opcaoVoto;
	@NotNull
	@NotEmpty
	private String associadoId;

	public OpcaoVoto getOpcaoVoto() {
		return opcaoVoto;
	}

	public String getAssociadoId() {
		return associadoId;
	}
}
