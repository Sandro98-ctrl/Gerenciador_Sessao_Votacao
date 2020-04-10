package br.com.compasso.gerenciador.util;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;

import br.com.compasso.gerenciador.model.OpcaoVoto;
import br.com.compasso.gerenciador.model.Voto;

public class ContabilizadorDeVotos {

	private final Collection<Voto> votos;

	public ContabilizadorDeVotos(Collection<Voto> votos) {
		this.votos = Collections.unmodifiableCollection(votos);
	}

	public Long votosAFavor() {
		return contabilizar(OpcaoVoto.SIM);
	}

	public Long votosContra() {
		return contabilizar(OpcaoVoto.NAO);
	}
	
	public BigDecimal porcentagemAFavor() {
		return new BigDecimal(votosAFavor()/ totalDeVotos());
	}
	
	public BigDecimal porcentagemContra() {
		return new BigDecimal(votosContra()/ totalDeVotos());
	}

	public Long totalDeVotos() {
		return (long) votos.size();
	}

	private Long contabilizar(OpcaoVoto opcaoVoto) {
		return votos.stream().filter(v -> v.getOpcaoVoto() == opcaoVoto).count();
	}

}
