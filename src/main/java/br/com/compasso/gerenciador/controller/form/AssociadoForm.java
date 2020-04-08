package br.com.compasso.gerenciador.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.compasso.gerenciador.model.Associado;

public class AssociadoForm {

	@NotNull
	@NotEmpty
	@CPF
	private String cpf;
	@NotNull
	@NotEmpty
	private String nome;

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}
	
}
