package br.com.compasso.gerenciador.converter;

import java.util.Collection;
import java.util.stream.Collectors;

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

	public VotoDTO toVotoDTO(Voto voto) {
		return new VotoDTO(voto);
	}
	
	public VotoDetalhadoDTO toVotoDetalhadoDTO(Voto voto) {
		return new VotoDetalhadoDTO(voto);
	}
	
	public VotoCriadoDTO toVotoCriadoDTO(Voto voto) {
		return new VotoCriadoDTO(voto);
	}
	
	public Collection<VotoDetalhadoDTO> toVotoDetalhadoDTOCollection(Collection<Voto> votos){
		return votos.stream().map(VotoDetalhadoDTO::new).collect(Collectors.toList());
	}
	
	public Voto toVoto(VotoForm form, AssociadoService associadoService, SessaoService sessaoService) {
		var opcao = form.getOpcaoVoto();
		var associado = associadoService.getOne(form.getAssociadoId());
		var sessao =  sessaoService.getOne(form.getSessaoId());
		return new Voto(opcao, associado, sessao);
	}
}
