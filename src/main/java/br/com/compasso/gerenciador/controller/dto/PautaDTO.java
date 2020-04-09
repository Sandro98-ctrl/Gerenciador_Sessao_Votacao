package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.Pauta;

public class PautaDTO {

	private final String id;
	private final String assunto;
	private final String descricao;
	
	public PautaDTO(Pauta pauta) {
		this.id = pauta.getId();
		this.assunto = pauta.getAssunto();
		this.descricao = pauta.getDescricao();
	}
	
	public String getId() {
		return id;
	}

	public String getAssunto() {
		return assunto;
	}

	public String getDescricao() {
		return descricao;
	}
}
