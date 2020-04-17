package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.EstadoSessao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultadosSessaoDTO {

	private EstadoSessao estadoSessao;
	private Long totalVotos;
	private Long votosAFavor;
	private Long votosContra;

}
