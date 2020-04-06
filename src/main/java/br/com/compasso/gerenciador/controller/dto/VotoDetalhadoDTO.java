package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.OpcaoVoto;
import br.com.compasso.gerenciador.model.Voto;

public class VotoDetalhadoDTO {

	private String id;
	private OpcaoVoto opcaoVoto;
	private AssociadoDTO associado;

	public VotoDetalhadoDTO(Voto voto) {
		this.id = voto.getId();
		this.opcaoVoto = voto.getOpcaoVoto();
		this.associado = new AssociadoDTO(voto.getAssociado());
	}
	
	public String getId() {
		return id;
	}

	public OpcaoVoto getOpcaoVoto() {
		return opcaoVoto;
	}

	public AssociadoDTO getAssociado() {
		return associado;
	}

}
