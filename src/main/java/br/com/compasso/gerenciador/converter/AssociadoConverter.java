package br.com.compasso.gerenciador.converter;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.compasso.gerenciador.controller.dto.AssociadoDTO;
import br.com.compasso.gerenciador.model.Associado;

@Component
public class AssociadoConverter{

	public AssociadoDTO toAssociadoDTO(Associado obj) {
		return new AssociadoDTO(obj);
	}
	
	public Collection<AssociadoDTO> toAssociadoDTOCollection(Collection<Associado> associados){
		return associados.stream().map(AssociadoDTO::new).collect(Collectors.toList());
	}
}
