package br.com.compasso.gerenciador.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.form.SessaoForm;
import br.com.compasso.gerenciador.controller.form.VotoForm;
import br.com.compasso.gerenciador.converter.SessaoConverter;
import br.com.compasso.gerenciador.converter.VotoConverter;
import br.com.compasso.gerenciador.model.Sessao;
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

	public List<Sessao> getAllSessoes() {
		return sessaoService.getAll();
	}
	
	public Optional<Sessao> getSessaoById(String id) {
		return sessaoService.getById(id);
	}

	public void save(Sessao sessao) {
		sessaoService.save(sessao);
	}
	
	public Sessao toSessao(SessaoForm form) {
		return sessaoConverter.toSessao(form, pautaService);
	}
	
	public void votar(VotoForm form, String sessaoId){
		var sessao = sessaoService.getSessaoById(sessaoId);
		var voto = votoConverter.toVoto(form, associadoService);
		
		if (sessao.addVoto(voto)) {
			votoService.save(voto);
			sessaoService.save(sessao);
			return;
		}
		
		throw new RuntimeException();
	}
}
