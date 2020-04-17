package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.EstadoSessao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessaoSimplificadaDTO {

	private String id;
	private EstadoSessao estado;

}
