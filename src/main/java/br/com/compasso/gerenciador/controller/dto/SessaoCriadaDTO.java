package br.com.compasso.gerenciador.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.compasso.gerenciador.model.Sessao;

public class SessaoCriadaDTO {

	private final String id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private final LocalDateTime dataHoraInicio;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private final LocalDateTime dataHoraTermino;
	private final String pautaId;

	public SessaoCriadaDTO(Sessao sessao) {
		this.id = sessao.getId();
		this.dataHoraInicio = sessao.getDataHoraInicio();
		this.dataHoraTermino = sessao.getDataHoraTermino();
		this.pautaId = sessao.getPauta().getId();
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

	public String getPautaId() {
		return pautaId;
	}

	public static List<SessaoCriadaDTO> convert(List<Sessao> lista) {
		return lista.stream().map(SessaoCriadaDTO::new).collect(Collectors.toList());
	}

}
