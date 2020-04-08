package br.com.compasso.gerenciador.business;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.ResultadosSessaoDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCompletaDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCriadaDTO;
import br.com.compasso.gerenciador.controller.form.SessaoForm;
import br.com.compasso.gerenciador.controller.form.VotoForm;
import br.com.compasso.gerenciador.converter.VotoConverter;
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
	private final VotoConverter votoConverter; 
	
	public SessaoBusiness(SessaoService sessaoService, PautaService pautaService, AssociadoService associadoService, VotoService votoService, VotoConverter votoConverter) {
		this.sessaoService = sessaoService;
		this.pautaService = pautaService;
		this.associadoService = associadoService;
		this.votoService = votoService;  
		this.votoConverter = votoConverter;
	}

	public Collection<SessaoCompletaDTO> getAllSessoes() {
		return sessaoService.getAll();
	}
	
	public SessaoCompletaDTO getById(String id) {
		return sessaoService.getSessaoCompleta(id);
	}
	
	public ResultadosSessaoDTO getResultadosDaSessao(String id) {
		return sessaoService.getResultadosSessao(id);
	}
	
	public SessaoCriadaDTO cadastrar(SessaoForm form) {
		return sessaoService.cadastrar(form, pautaService);
	}
	
	public void votar(VotoForm form, String sessaoId){
		sessaoService.votar(associadoService, votoService, form, sessaoId);
	}
}
