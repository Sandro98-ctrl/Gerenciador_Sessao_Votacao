package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.OpcaoVoto;
import br.com.compasso.gerenciador.model.Voto;

public class VotoDetalhadoDTO {

	private final String id;
	private final OpcaoVoto opcaoVoto;
	private final AssociadoDTO associado;
	private final SessaoSimplificadaDTO sessao;

	public VotoDetalhadoDTO(Voto voto) {
		this.id = voto.getId();
		this.opcaoVoto = voto.getOpcaoVoto();
		this.associado = new AssociadoDTO(voto.getAssociado());
		this.sessao = new SessaoSimplificadaDTO(voto.getSessao());
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
	
	public SessaoSimplificadaDTO getSessao() {
		return sessao;
	}

}
