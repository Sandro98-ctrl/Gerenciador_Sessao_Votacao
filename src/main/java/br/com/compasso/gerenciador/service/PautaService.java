package br.com.compasso.gerenciador.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.PautaDTO;
import br.com.compasso.gerenciador.controller.form.PautaForm;
import br.com.compasso.gerenciador.converter.PautaConverter;
import br.com.compasso.gerenciador.exception.PautaNotFoundException;
import br.com.compasso.gerenciador.model.Pauta;
import br.com.compasso.gerenciador.repository.PautaRepository;

@Service
public class PautaService {

	private final PautaRepository pautaRepository;
	private final PautaConverter pautaConverter;
	
	public PautaService(PautaRepository pautaRepository, PautaConverter pautaConverter) {
		this.pautaRepository = pautaRepository;
		this.pautaConverter = pautaConverter;
	}
	
	public Collection<PautaDTO> getAll(){
		var pautas = pautaRepository.findAll();
		return pautaConverter.toPautaDTOCollection(pautas);
	}
	
	public PautaDTO getById(String id){
		var pauta = getOne(id);
		return pautaConverter.toPautaDTO(pauta);
	}
	
	public Pauta getOne(String id){
		var pauta = pautaRepository.findById(id);
		return pauta.orElseThrow(PautaNotFoundException::new);
	}
	
	public PautaDTO cadastrar(PautaForm form) {
		var pauta = pautaConverter.toPauta(form);
		pautaRepository.save(pauta);
		return pautaConverter.toPautaDTO(pauta);
	}
	
}
