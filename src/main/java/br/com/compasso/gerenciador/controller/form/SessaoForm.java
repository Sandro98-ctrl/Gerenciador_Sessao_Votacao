package br.com.compasso.gerenciador.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SessaoForm {

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraTermino;
	@NotNull
	@NotEmpty
	private String pautaId;
	
	public LocalDateTime getDataHoraTermino() {
		return dataHoraTermino;
	}

	public String getPautaId() {
		return pautaId;
	}
	
}
