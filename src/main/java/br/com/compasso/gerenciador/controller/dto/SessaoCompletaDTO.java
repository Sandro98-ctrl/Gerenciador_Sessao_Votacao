package br.com.compasso.gerenciador.controller.dto;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.compasso.gerenciador.model.Sessao;
import br.com.compasso.gerenciador.model.Voto;

public class SessaoCompletaDTO {

	private String id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraInicio;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraTermino;
	private PautaDTO pauta;
	private Collection<VotoDTO> votos;
	
	public SessaoCompletaDTO(Sessao sessao) {
		this.id = sessao.getId();
		this.dataHoraInicio = sessao.getDataHoraInicio();
		this.dataHoraTermino = sessao.getDataHoraTermino();
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

	public PautaDTO getPauta() {
		return pauta;
	}

	public Collection<VotoDTO> getVotos() {
		return votos;
	}

	public static List<SessaoCompletaDTO> convert(List<Sessao> lista) {
		return lista.stream().map(SessaoCompletaDTO::new).collect(Collectors.toList());
	}
	
	private Collection<VotoDTO> carregaVotos(Collection<Voto> votos){
		return votos.stream().map(VotoDTO::new).collect(Collectors.toList());
	}
}
