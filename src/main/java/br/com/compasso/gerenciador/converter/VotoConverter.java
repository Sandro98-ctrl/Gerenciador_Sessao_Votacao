package br.com.compasso.gerenciador.converter;

import java.util.Arrays;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.compasso.gerenciador.controller.dto.VotoCriadoDTO;
import br.com.compasso.gerenciador.controller.dto.VotoDTO;
import br.com.compasso.gerenciador.controller.dto.VotoDetalhadoDTO;
import br.com.compasso.gerenciador.controller.form.VotoForm;
import br.com.compasso.gerenciador.model.Voto;
import br.com.compasso.gerenciador.service.AssociadoService;
import br.com.compasso.gerenciador.service.SessaoService;

@Component
public class VotoConverter {

	private final ModelMapper mapper;

	public VotoConverter(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public VotoDTO toVotoDTO(Voto voto) {
		return mapper.map(voto, VotoDTO.class);
	}

	public VotoDetalhadoDTO toVotoDetalhadoDTO(Voto voto) {
		return mapper.map(voto, VotoDetalhadoDTO.class);
	}

	public VotoCriadoDTO toVotoCriadoDTO(Voto voto) {
		return mapper.map(voto, VotoCriadoDTO.class);
	}

	public Collection<VotoDetalhadoDTO> toVotoDetalhadoDTOCollection(Collection<Voto> votos) {
		return Arrays.asList(mapper.map(votos, VotoDetalhadoDTO[].class));
	}

	public Voto toVoto(VotoForm form, AssociadoService associadoService, SessaoService sessaoService) {
		var opcaoVoto = form.getOpcaoVoto();
		var associado = associadoService.getOne(form.getAssociadoId());
		var sessao = sessaoService.getOne(form.getSessaoId());
		return new Voto(opcaoVoto, associado, sessao);
	}
}
