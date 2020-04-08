package br.com.compasso.gerenciador.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.ResultadosSessaoDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCompletaDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCriadaDTO;
import br.com.compasso.gerenciador.controller.form.SessaoForm;
import br.com.compasso.gerenciador.controller.form.VotoForm;
import br.com.compasso.gerenciador.converter.SessaoConverter;
import br.com.compasso.gerenciador.exception.JaVotouException;
import br.com.compasso.gerenciador.exception.SessaoFechadaException;
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

	public Collection<Sessao> getSessoesExpiradas() {
		return sessaoRepository.findByEstadoAndDataHoraTerminoLessThan(EstadoSessao.ABERTA, LocalDateTime.now());
	}

	public SessaoCriadaDTO cadastrar(SessaoForm form, PautaService pautaService) {
		var sessao = sessaoConverter.toSessao(form, pautaService);
		sessaoRepository.save(sessao);
		return sessaoConverter.toSessaoCriadaDTO(sessao);
	}

	public SessaoCompletaDTO getSessaoCompleta(String id) {
		var sessao = getSessaoById(id);
		return sessaoConverter.toSessaoCompletaDTO(sessao);
	}

	public ResultadosSessaoDTO getResultadosSessao(String id) {
		var sessao = getSessaoById(id);
		return sessaoConverter.toResultadosSessaoDTO(sessao);
	}

	public void encerraSessao(Sessao sessao) {
		if (sessao.isSessaoAberta()) {
			sessao.setEstado(EstadoSessao.ENCERRADA);
			sessaoRepository.save(sessao);
		}
	}

	public void votar(AssociadoService associadoService, VotoService votoService, VotoForm form, String sessaoId) {
		var sessao = getSessaoById(sessaoId);
		var voto = votoService.getVotoFromForm(form, associadoService, sessao);

		if (sessao.isSessaoExpirada()) {
			throw new SessaoFechadaException("A sessão está encerrada");
		}

		if (!sessao.addVoto(voto)) {
			throw new JaVotouException("Este associado já votou nesta sessão");
		}

		votoService.save(voto);
		sessaoRepository.save(sessao);
	}

	private Sessao getSessaoById(String id) {
		var sessao = sessaoRepository.findById(id);
		return sessao.orElseThrow(() -> new NoSuchElementException("Sessão não encontrada"));
	}
}
