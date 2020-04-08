package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.EstadoSessao;
import br.com.compasso.gerenciador.model.Sessao;

public class SessaoSimplificadaDTO {

	private String id;
	private EstadoSessao estado;

	public SessaoSimplificadaDTO(Sessao sessao) {
		this.id = sessao.getId();
		this.estado = sessao.getEstado();
	}

	public String getId() {
		return id;
	}

	public EstadoSessao getEstado() {
		return estado;
	}

}
