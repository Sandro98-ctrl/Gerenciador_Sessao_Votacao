package br.com.compasso.gerenciador.converter;

import java.time.LocalDateTime;
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
		var pauta = pautaService.getPautaById(form.getPautaId());
		var sessao = new Sessao();
		
		if(form.getDataHoraTermino() != null) {
			if(form.getDataHoraTermino().isBefore(LocalDateTime.now())) {
				throw new IllegalArgumentException("Data e hora informada é inferior a data e hora atual");
			}
			
			sessao.setDataHoraTermino(form.getDataHoraTermino());
		}
		
		sessao.setPauta(pauta);
		return sessao;
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
