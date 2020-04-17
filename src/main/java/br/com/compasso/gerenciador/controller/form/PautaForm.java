package br.com.compasso.gerenciador.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PautaForm {

	@NotNull
	@NotEmpty
	private String assunto;
	@NotNull
	@NotEmpty
	private String descricao;

}
