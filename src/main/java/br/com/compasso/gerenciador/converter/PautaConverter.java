package br.com.compasso.gerenciador.converter;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.compasso.gerenciador.controller.dto.PautaDTO;
import br.com.compasso.gerenciador.model.Pauta;

@Component
public class PautaConverter {

	public PautaDTO toPautaDTO(Pauta pauta) {
		return new PautaDTO(pauta);
	}

	public Collection<PautaDTO> toPautaDTOCollection(Collection<Pauta> pautas){
		return pautas.stream().map(PautaDTO::new).collect(Collectors.toList());
	}
}
