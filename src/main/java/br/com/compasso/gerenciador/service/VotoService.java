package br.com.compasso.gerenciador.service;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.VotoDetalhadoDTO;
import br.com.compasso.gerenciador.controller.form.VotoForm;
import br.com.compasso.gerenciador.converter.VotoConverter;
import br.com.compasso.gerenciador.model.Sessao;
import br.com.compasso.gerenciador.model.Voto;
import br.com.compasso.gerenciador.repository.VotoRepository;

@Service
public class VotoService {

	private final VotoRepository votoRepository;
	private final VotoConverter votoConverter;

	public VotoService(VotoRepository votoRepository, VotoConverter votoConverter) {
		this.votoRepository = votoRepository;
		this.votoConverter = votoConverter;
	}
	
	public Collection<VotoDetalhadoDTO> getAll(){
		var votos = votoRepository.findAll();
		return votoConverter.toVotoDetalhadoDTOCollection(votos);
	}
	
	public VotoDetalhadoDTO getById(String id){
		var votos = votoRepository.findById(id);
		return votos.map(votoConverter::toVotoDetalhadoDTO)
				.orElseThrow(() -> new NoSuchElementException("Voto não encontrado"));
	}
	
	public Voto getVotoFromForm(VotoForm form, AssociadoService associadoService, Sessao sessao) {
		return votoConverter.toVoto(form, associadoService, sessao);
	}

	public void save(Voto voto) {
		votoRepository.save(voto);
	}
}
