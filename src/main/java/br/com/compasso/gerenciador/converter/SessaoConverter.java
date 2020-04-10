package br.com.compasso.gerenciador.converter;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.compasso.gerenciador.controller.dto.ResultadosSessaoDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCompletaDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCriadaDTO;
import br.com.compasso.gerenciador.controller.form.SessaoForm;
import br.com.compasso.gerenciador.model.Sessao;
import br.com.compasso.gerenciador.service.PautaService;

@Component
public class SessaoConverter {

	public Sessao toSessao(SessaoForm form, PautaService pautaService) {
		var pauta = pautaService.getOne(form.getPautaId());
		var dataHoraTermino = form.getDataHoraTermino();		
		return new Sessao(pauta, dataHoraTermino);
	}

	public SessaoCriadaDTO toSessaoCriadaDTO(Sessao sessao) {
		return new SessaoCriadaDTO(sessao);
	}
	
	public ResultadosSessaoDTO toResultadosSessaoDTO(Sessao sessao) {
		return new ResultadosSessaoDTO(sessao);
	}
	
	public SessaoCompletaDTO toSessaoCompletaDTO(Sessao sessao) {
		return new SessaoCompletaDTO(sessao);
	}
	
	public Collection<SessaoCompletaDTO> toSessaoCompletaDTOCollection(Collection<Sessao> sessoes) {
		return sessoes.stream().map(SessaoCompletaDTO::new).collect(Collectors.toList());
	}
	
}
