package br.com.compasso.gerenciador.service;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.ResultadosSessaoDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCompletaDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCriadaDTO;
import br.com.compasso.gerenciador.controller.form.SessaoForm;
import br.com.compasso.gerenciador.converter.SessaoConverter;
import br.com.compasso.gerenciador.exception.SessaoNotFoundException;
import br.com.compasso.gerenciador.model.EstadoSessao;
import br.com.compasso.gerenciador.model.Sessao;
import br.com.compasso.gerenciador.repository.SessaoRepository;

@Service
public class SessaoService {

	private final SessaoRepository sessaoRepository;
	private final SessaoConverter sessaoConverter;

	public SessaoService(SessaoRepository sessaoRepository, SessaoConverter sessaoConverter) {
		this.sessaoRepository = sessaoRepository;
		this.sessaoConverter = sessaoConverter;
	}

	public Collection<SessaoCompletaDTO> getAll() {
		var sessoes = sessaoRepository.findAll();
		return sessaoConverter.toSessaoCompletaDTOCollection(sessoes);
	}

	public SessaoCompletaDTO getSessaoCompleta(String id) {
		var sessao = getOne(id);
		return sessaoConverter.toSessaoCompletaDTO(sessao);
	}

	public ResultadosSessaoDTO getResultadosSessao(String id) {
		var sessao = getOne(id);
		return sessaoConverter.toResultadosSessaoDTO(sessao);
	}
	
	public Sessao getOne(String id) {
		var sessao = sessaoRepository.findById(id);
		return sessao.orElseThrow(SessaoNotFoundException::new);
	}
	
	public SessaoCriadaDTO cadastrar(SessaoForm form, PautaService pautaService) {
		var sessao = sessaoConverter.toSessao(form, pautaService);
		sessaoRepository.save(sessao);
		return sessaoConverter.toSessaoCriadaDTO(sessao);
	}

	public void encerraSessoesExpiradas() {
		var expiradas = sessaoRepository.findByEstadoAndDataHoraTerminoLessThan(EstadoSessao.ABERTA, LocalDateTime.now());
		if (expiradas.isEmpty()) return;
		
		expiradas.forEach(s -> {
			s.encerrar();
			sessaoRepository.save(s);
		});
	}

}
