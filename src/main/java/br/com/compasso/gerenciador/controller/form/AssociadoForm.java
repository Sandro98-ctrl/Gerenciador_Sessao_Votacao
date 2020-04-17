package br.com.compasso.gerenciador.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoForm {

	@NotNull
	@NotEmpty
	@CPF
	private String cpf;
	@NotNull
	@NotEmpty
	private String nome;

}
