package br.com.compasso.gerenciador.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.compasso.gerenciador.model.Pauta;

public class PautaForm {

	@NotNull
	@NotEmpty
	private String assunto;
	
	@NotNull
	@NotEmpty
	private String descricao;
	
	public String getAssunto() {
		return assunto;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
