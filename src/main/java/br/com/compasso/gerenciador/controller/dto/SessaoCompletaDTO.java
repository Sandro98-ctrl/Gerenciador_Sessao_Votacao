package br.com.compasso.gerenciador.controller.dto;

import java.time.LocalDateTime;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.compasso.gerenciador.model.EstadoSessao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessaoCompletaDTO {

	private String id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraInicio;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraTermino;
	private EstadoSessao estadoSessao;
	private PautaDTO pauta;
	private Collection<VotoDTO> votos;

}
