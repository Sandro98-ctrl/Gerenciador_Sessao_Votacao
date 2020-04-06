package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.Associado;

public class AssociadoDTO {

	private String id;
	private String cpf;
	private String nome;

	public AssociadoDTO(Associado associado) {
		this.id = associado.getId();
		this.cpf = associado.getCpf();
		this.nome = associado.getNome();
	}

	public String getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}
}
