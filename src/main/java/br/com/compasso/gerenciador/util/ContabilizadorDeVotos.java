package br.com.compasso.gerenciador.util;

import java.util.Collection;

import br.com.compasso.gerenciador.model.OpcaoVoto;
import br.com.compasso.gerenciador.model.Voto;

public class ContabilizadorDeVotos {

	private final Collection<Voto> votos;

	public ContabilizadorDeVotos(Collection<Voto> votos) {
		this.votos = votos;
	}

	public Long votosAFavor() {
		return contabilizar(OpcaoVoto.SIM);
	}

	public Long votosContra() {
		return contabilizar(OpcaoVoto.NAO);
	}

	public Long totalDeVotos() {
		return (long) votos.size();
	}

	private Long contabilizar(OpcaoVoto opcaoVoto) {
		return votos.stream().filter(v -> v.getOpcaoVoto() == opcaoVoto).count();
	}

}
