package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.OpcaoVoto;
import br.com.compasso.gerenciador.model.Voto;

public class VotoDTO {

	private OpcaoVoto voto;
	private String associadoId;

	public VotoDTO(Voto voto) {
		this.voto = voto.getOpcaoVoto();
		this.associadoId = voto.getAssociado().getId();
	}
	
	public OpcaoVoto getVoto() {
		return voto;
	}

	public String getAssociadoId() {
		return associadoId;
	}

}
