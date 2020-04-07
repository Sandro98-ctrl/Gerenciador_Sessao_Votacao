package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.EstadoSessao;
import br.com.compasso.gerenciador.model.Sessao;

public class ResultadosSessaoDTO {

	private EstadoSessao estadoSessao;
	private Integer totalVotos;
	private Long votosAFavor;
	private Long votosContra;

	public ResultadosSessaoDTO(Sessao sessao) {
		this.estadoSessao = sessao.getEstado();
		this.totalVotos = sessao.getVotos().size();
		this.votosAFavor = sessao.contaVotosAFavor();
		this.votosContra = sessao.contaVotosContra();
	}
	
	public EstadoSessao getEstadoSessao() {
		return estadoSessao;
	}
	
	public Integer getTotalVotos() {
		return totalVotos;
	}

	public Long getVotosAFavor() {
		return votosAFavor;
	}

	public Long getVotosContra() {
		return votosContra;
	}

}
