package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.OpcaoVoto;
import br.com.compasso.gerenciador.model.Voto;

public class VotoCriadoDTO {

	private final String id;
	private final OpcaoVoto opcaoVoto;
	private final String associadoId;
	private final String sessaoId;

	public VotoCriadoDTO(Voto voto) {
		this.id = voto.getId();
		this.opcaoVoto = voto.getOpcaoVoto();
		this.associadoId = voto.getAssociado().getId();
		this.sessaoId = voto.getSessao().getId();
	}

	public String getId() {
		return id;
	}

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
