package br.com.compasso.gerenciador.controller.dto;

import br.com.compasso.gerenciador.model.OpcaoVoto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotoCriadoDTO {

	private String id;
	private OpcaoVoto opcaoVoto;
	private String associadoId;
	private String sessaoId;

}
