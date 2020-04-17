package br.com.compasso.gerenciador.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoDTO {

	private String id;
	private String cpf;
	private String nome;

}