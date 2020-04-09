package br.com.compasso.gerenciador.business;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.ResultadosSessaoDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCompletaDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCriadaDTO;
import br.com.compasso.gerenciador.controller.form.SessaoForm;
import br.com.compasso.gerenciador.service.PautaService;
import br.com.compasso.gerenciador.service.SessaoService;

@Service
public class SessaoBusiness {

	private final SessaoService sessaoService;
	private final PautaService pautaService;
	
	public SessaoBusiness(SessaoService sessaoService, PautaService pautaService) {
		this.sessaoService = sessaoService;
		this.pautaService = pautaService;
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
}
