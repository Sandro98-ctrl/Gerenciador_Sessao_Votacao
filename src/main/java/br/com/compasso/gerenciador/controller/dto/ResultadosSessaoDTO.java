package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.EstadoSessao;
import br.com.compasso.gerenciador.model.Sessao;
import br.com.compasso.gerenciador.util.ContabilizadorDeVotos;

public class ResultadosSessaoDTO {

	private final EstadoSessao estadoSessao;
	private final Long totalVotos;
	private final Long votosAFavor;
	private final Long votosContra;

	public ResultadosSessaoDTO(Sessao sessao) {
		var contabilizador = new ContabilizadorDeVotos(sessao.getVotos());
		this.estadoSessao = sessao.getEstado();
		this.totalVotos = contabilizador.totalDeVotos();
		this.votosAFavor = contabilizador.votosAFavor();
		this.votosContra = contabilizador.votosContra();
	}
	
	public EstadoSessao getEstadoSessao() {
		return estadoSessao;
	}
	
	public Long getTotalVotos() {
		return totalVotos;
	}

	public Long getVotosAFavor() {
		return votosAFavor;
	}

	public Long getVotosContra() {
		return votosContra;
	}

}
