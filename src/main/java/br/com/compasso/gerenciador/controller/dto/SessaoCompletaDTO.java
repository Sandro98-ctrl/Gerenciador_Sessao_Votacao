package br.com.compasso.gerenciador.controller.dto;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.compasso.gerenciador.model.EstadoSessao;
import br.com.compasso.gerenciador.model.Sessao;
import br.com.compasso.gerenciador.model.Voto;

public class SessaoCompletaDTO {

	private String id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraInicio;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraTermino;
	private EstadoSessao estadoSessao;
	private PautaDTO pauta;
	private Collection<VotoDTO> votos;
	
	public SessaoCompletaDTO(Sessao sessao) {
		this.id = sessao.getId();
		this.dataHoraInicio = sessao.getDataHoraInicio();
		this.dataHoraTermino = sessao.getDataHoraTermino();
		this.estadoSessao = sessao.getEstado();
		this.pauta = new PautaDTO(sessao.getPauta());
		this.votos = carregaVotos(sessao.getVotos());
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
	
	public EstadoSessao getEstadoSessao() {
		return estadoSessao;
	}

	public PautaDTO getPauta() {
		return pauta;
	}

	public Collection<VotoDTO> getVotos() {
		return votos;
	}
	
	private Collection<VotoDTO> carregaVotos(Collection<Voto> votos){
		return votos.stream().map(VotoDTO::new).collect(Collectors.toList());
	}
}
