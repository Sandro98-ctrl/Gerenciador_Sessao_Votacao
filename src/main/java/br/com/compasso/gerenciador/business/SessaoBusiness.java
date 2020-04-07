package br.com.compasso.gerenciador.business;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.ResultadosSessaoDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCompletaDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCriadaDTO;
import br.com.compasso.gerenciador.controller.form.SessaoForm;
import br.com.compasso.gerenciador.controller.form.VotoForm;
import br.com.compasso.gerenciador.converter.SessaoConverter;
import br.com.compasso.gerenciador.converter.VotoConverter;
import br.com.compasso.gerenciador.exception.JaVotouException;
import br.com.compasso.gerenciador.exception.SessaoFechadaException;
import br.com.compasso.gerenciador.service.AssociadoService;
import br.com.compasso.gerenciador.service.PautaService;
import br.com.compasso.gerenciador.service.SessaoService;
import br.com.compasso.gerenciador.service.VotoService;

@Service
public class SessaoBusiness {

	private final SessaoService sessaoService;
	private final PautaService pautaService;
	private final AssociadoService associadoService;
	private final VotoService votoService;
	private final SessaoConverter sessaoConverter;
	private final VotoConverter votoConverter; 
	
	public SessaoBusiness(SessaoService sessaoService, PautaService pautaService, AssociadoService associadoService, VotoService votoService, SessaoConverter sessaoConverter, VotoConverter votoConverter) {
		this.sessaoService = sessaoService;
		this.pautaService = pautaService;
		this.associadoService = associadoService;
		this.votoService = votoService;  
		this.sessaoConverter = sessaoConverter;
		this.votoConverter = votoConverter;
	}

	public Collection<SessaoCompletaDTO> getAllSessoes() {
		var sessoes = sessaoService.getAll();
		return sessaoConverter.toSessaoCompletaDTOCollection(sessoes);
	}
	
	public SessaoCompletaDTO getById(String id) {
		var sessao = sessaoService.getSessaoById(id);
		return sessaoConverter.toSessaoCompletaDTO(sessao);
	}
	
	public ResultadosSessaoDTO getResultadosDaSessao(String id) {
		var sessao = sessaoService.getSessaoById(id);
		return sessaoConverter.toResultadosSessaoDTO(sessao);
	}
	
	public SessaoCriadaDTO cadastrar(SessaoForm form) {
		var sessao = sessaoConverter.toSessao(form, pautaService);
		sessaoService.save(sessao);
		return sessaoConverter.toSessaoCriadaDTO(sessao);
	}
	
	public void votar(VotoForm form, String sessaoId){
		var sessao = sessaoService.getSessaoById(sessaoId);
		var voto = votoConverter.toVoto(form, associadoService);
		
		if(sessao.isSessaoExpirada()) {
			throw new SessaoFechadaException("A sessão está encerrada");
		}
		
		if (sessao.addVoto(voto)) {
			throw new JaVotouException("Este associado já votou nesta sessão");
		}
		
		votoService.save(voto);
		sessaoService.save(sessao);
	}
}
