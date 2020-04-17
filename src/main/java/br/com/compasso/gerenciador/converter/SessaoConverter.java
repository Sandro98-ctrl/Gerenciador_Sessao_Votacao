package br.com.compasso.gerenciador.converter;

import java.util.Arrays;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.compasso.gerenciador.controller.dto.ResultadosSessaoDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCompletaDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCriadaDTO;
import br.com.compasso.gerenciador.controller.form.SessaoForm;
import br.com.compasso.gerenciador.model.Sessao;
import br.com.compasso.gerenciador.service.PautaService;

@Component
public class SessaoConverter {

	private final ModelMapper mapper;

	public SessaoConverter(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public SessaoCriadaDTO toSessaoCriadaDTO(Sessao sessao) {
		return mapper.map(sessao, SessaoCriadaDTO.class);
	}
	
	public ResultadosSessaoDTO toResultadosSessaoDTO(Sessao sessao) {
		return mapper.map(sessao, ResultadosSessaoDTO.class);
	}
	
	public SessaoCompletaDTO toSessaoCompletaDTO(Sessao sessao) {
		return mapper.map(sessao, SessaoCompletaDTO.class);
	}
	
	public Collection<SessaoCompletaDTO> toSessaoCompletaDTOCollection(Collection<Sessao> sessoes) {
		return Arrays.asList(mapper.map(sessoes, SessaoCompletaDTO[].class));
	}
	
	public Sessao toSessao(SessaoForm form, PautaService pautaService) {
		var dataHoraTermino = form.getDataHoraTermino();
		var pauta = pautaService.getOne(form.getPautaId());		
		return new Sessao(dataHoraTermino, pauta);
	}
	
}
