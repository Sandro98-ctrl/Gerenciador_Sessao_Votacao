package br.com.compasso.gerenciador.converter;

import java.util.Arrays;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.compasso.gerenciador.controller.dto.AssociadoDTO;
import br.com.compasso.gerenciador.controller.form.AssociadoForm;
import br.com.compasso.gerenciador.model.Associado;

@Component
public class AssociadoConverter {

	private final ModelMapper mapper;

	public AssociadoConverter(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public AssociadoDTO toAssociadoDTO(Associado associado) {
		return mapper.map(associado, AssociadoDTO.class);
	}

	public Collection<AssociadoDTO> toAssociadoDTOCollection(Collection<Associado> associados) {
		return Arrays.asList(mapper.map(associados, AssociadoDTO[].class));
	}

	public Associado toAssociado(AssociadoForm form) {
		return new Associado(form.getCpf(), form.getNome());
	}

}
