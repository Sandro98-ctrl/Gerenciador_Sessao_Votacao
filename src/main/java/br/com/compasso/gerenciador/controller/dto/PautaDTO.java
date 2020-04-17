package br.com.compasso.gerenciador.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PautaDTO {

	private String id;
	private String assunto;
	private String descricao;
	
}
