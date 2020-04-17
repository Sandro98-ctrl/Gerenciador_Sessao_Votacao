package br.com.compasso.gerenciador.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.compasso.gerenciador.model.OpcaoVoto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotoForm {

	@NotNull
	private OpcaoVoto opcaoVoto;
	@NotNull
	@NotEmpty
	private String associadoId;
	@NotNull
	@NotEmpty
	private String sessaoId;

}
