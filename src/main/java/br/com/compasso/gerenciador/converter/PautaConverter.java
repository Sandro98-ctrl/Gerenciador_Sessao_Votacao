package br.com.compasso.gerenciador.converter;

import java.util.Arrays;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.compasso.gerenciador.controller.dto.PautaDTO;
import br.com.compasso.gerenciador.controller.form.PautaForm;
import br.com.compasso.gerenciador.model.Pauta;

@Component
public class PautaConverter {

	private final ModelMapper mapper;
	
	public PautaConverter(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public PautaDTO toPautaDTO(Pauta pauta) {
		return mapper.map(pauta, PautaDTO.class);
	}

	public Collection<PautaDTO> toPautaDTOCollection(Collection<Pauta> pautas){
		return Arrays.asList(mapper.map(pautas, PautaDTO[].class));
	}

	public Pauta toPauta(PautaForm form) {
		return new Pauta(form.getAssunto(), form.getDescricao());
	}
}
