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
	
	public Sessao() {
		dataHoraInicio = LocalDateTime.now();
		dataHoraTermino = dataHoraInicio.plusMinutes(1);
		estado = EstadoSessao.ABERTA;
		votos = new HashSet<Voto>();
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

	public void setDataHoraTermino(LocalDateTime dataHoraTermino) {
		this.dataHoraTermino = dataHoraTermino;
	}

	public EstadoSessao getEstado() {
		return estado;
	}

	public void setEstado(EstadoSessao estado) {
		this.estado = estado;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public Collection<Voto> getVotos() {
		return Collections.unmodifiableCollection(votos);
	}

	public boolean addVoto(Voto voto) {
		return votos.contains(voto) ? false : votos.add(voto);
	}
	
	public Long contaVotosAFavor() {
		return votos.stream().filter(v -> v.getOpcaoVoto() == OpcaoVoto.SIM).count();
	}
	
	public Long contaVotosContra() {
		return votos.stream().filter(v -> v.getOpcaoVoto() == OpcaoVoto.NAO).count();
	}
	
//	@Scheduled(fixedDelay = 5000)
//	public void checkSession() {
//		
//	}

}
