package br.com.compasso.gerenciador.converter;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.compasso.gerenciador.controller.dto.VotoDTO;
import br.com.compasso.gerenciador.controller.dto.VotoDetalhadoDTO;
import br.com.compasso.gerenciador.controller.form.VotoForm;
import br.com.compasso.gerenciador.model.OpcaoVoto;
import br.com.compasso.gerenciador.model.Sessao;
import br.com.compasso.gerenciador.model.Voto;
import br.com.compasso.gerenciador.service.AssociadoService;

@Component
public class VotoConverter {

	public VotoDTO toVotoDTO(Voto voto) {
		return new VotoDTO(voto);
	}
	
	public VotoDetalhadoDTO toVotoDetalhadoDTO(Voto voto) {
		return new VotoDetalhadoDTO(voto);
	}
	
	public Collection<VotoDetalhadoDTO> toVotoDetalhadoDTOCollection(Collection<Voto> votos){
		return votos.stream().map(VotoDetalhadoDTO::new).collect(Collectors.toList());
	}

	public Voto toVoto(VotoForm form, AssociadoService associadoService, Sessao sessao) {
		var opcao = OpcaoVoto.valueOf(form.getOpcaoVoto());
		var associado = associadoService.getAssociadoById(form.getAssociadoId());
		var voto = new Voto();
		voto.setOpcaoVoto(opcao);
		voto.setAssociado(associado);
		voto.setSessao(sessao);
		
		return voto;
	}
}
