package br.com.compasso.gerenciador.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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
	
	public Sessao(Pauta pauta, LocalDateTime dataHoraTermino) {
		this(pauta);
		
		if(dataHoraTermino == null) {
			throw new IllegalArgumentException("Data/hora é inválida");
		}
		
		if(dataHoraTermino.isBefore(dataHoraInicio)) {
			throw new IllegalArgumentException("Data/hora é inferior a data/hora atual");
		}
		
		this.dataHoraTermino = dataHoraTermino;
	}
	
	public Sessao(Pauta pauta) {
		this();
		this.pauta = pauta;
	}
	
	public Sessao() {
		this.dataHoraInicio = LocalDateTime.now();
		this.dataHoraTermino = dataHoraInicio.plusMinutes(1);
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
		return votos.contains(voto) ? false : votos.add(voto);
	}
	
	public boolean isSessaoExpirada() {
		return dataHoraTermino.isBefore(LocalDateTime.now());
	}
	
	public void encerrar() {
		this.estado = EstadoSessao.ENCERRADA;
	}

}
