package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.Pauta;

public class PautaDTO {

	private String id;
	private String assunto;
	private String descricao;
	
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
