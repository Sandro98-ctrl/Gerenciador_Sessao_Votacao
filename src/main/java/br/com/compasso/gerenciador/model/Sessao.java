package br.com.compasso.gerenciador.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.compasso.gerenciador.exception.JaVotouException;
import br.com.compasso.gerenciador.exception.SessaoFechadaException;

@Document(collection = "sessoes")
@TypeAlias("Sessao")
public class Sessao {

	@Id
	private String id;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraTermino;
	private EstadoSessao estado;
	@DBRef
	private Pauta pauta;
	@DBRef
	private Collection<Voto> votos;
	
	public Sessao(LocalDateTime dataHoraTermino, Pauta pauta) {
		this();
		dataHoraTermino = Optional.ofNullable(dataHoraTermino).orElse(dataHoraInicio.plusMinutes(1));

		if (dataHoraTermino.isBefore(dataHoraInicio)) {
			throw new IllegalArgumentException("Data/hora é inferior a data/hora atual");
		}
		
		if (pauta == null) {
			throw new IllegalArgumentException("Pauta está nula");
		}
		
		this.dataHoraTermino = dataHoraTermino;
		this.pauta = pauta;
	}

	private Sessao() {
		this.dataHoraInicio = LocalDateTime.now();
		this.estado = EstadoSessao.ABERTA;
		this.votos = new HashSet<Voto>();
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public LocalDateTime getDataHoraTermino() {
		return dataHoraTermino;
	}

	public EstadoSessao getEstado() {
		return estado;
	}

	public Pauta getPauta() {
		return pauta;
	}
	
	public Collection<Voto> getVotos() {
		return Collections.unmodifiableCollection(votos);
	}

	public boolean addVoto(Voto voto) {
		if (votos.contains(voto)) {
			throw new JaVotouException("Este associado já votou nesta sessão");
		}

		return votos.add(voto);
	}

	public boolean isExpirada() {
		return dataHoraTermino.isBefore(LocalDateTime.now());
	}
	
	public void verificaSeEncerrada() {
		if (isExpirada()) {
			throw new SessaoFechadaException("A sessão está encerrada");
		}
	}

	public void encerrar() {
		this.estado = EstadoSessao.ENCERRADA;
	}

}
