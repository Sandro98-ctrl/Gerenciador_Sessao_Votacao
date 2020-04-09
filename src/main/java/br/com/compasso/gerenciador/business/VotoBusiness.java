package br.com.compasso.gerenciador.business;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.VotoCriadoDTO;
import br.com.compasso.gerenciador.controller.dto.VotoDetalhadoDTO;
import br.com.compasso.gerenciador.controller.form.VotoForm;
import br.com.compasso.gerenciador.service.AssociadoService;
import br.com.compasso.gerenciador.service.SessaoService;
import br.com.compasso.gerenciador.service.VotoService;

@Service
public class VotoBusiness {

	private final VotoService votoService;
	private final AssociadoService associadoService;
	private final SessaoService sessaoService;
	
	public VotoBusiness(VotoService votoService, AssociadoService associadoService, SessaoService sessaoService) {
		this.votoService = votoService;
		this.associadoService = associadoService;
		this.sessaoService = sessaoService;
	}
	
	public Collection<VotoDetalhadoDTO> getAll(){
		return votoService.getAll();
	}
	
	public VotoDetalhadoDTO getById(String id){
		return votoService.getById(id);
	}
	
	public VotoCriadoDTO cadastrar(VotoForm form) {
		return votoService.cadastrar(form, associadoService, sessaoService);
	}
}
