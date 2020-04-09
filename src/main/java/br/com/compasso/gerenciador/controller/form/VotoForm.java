package br.com.compasso.gerenciador.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.compasso.gerenciador.model.OpcaoVoto;

public class VotoForm {

	@NotNull
	private OpcaoVoto opcaoVoto;
	@NotNull
	@NotEmpty
	private String associadoId;
	@NotNull
	@NotEmpty
	private String sessaoId;

	public OpcaoVoto getOpcaoVoto() {
		return opcaoVoto;
	}

	public String getAssociadoId() {
		return associadoId;
	}
	
	public String getSessaoId() {
		return sessaoId;
	}
	
}
