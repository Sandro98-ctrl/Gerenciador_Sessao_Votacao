package br.com.compasso.gerenciador.service;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.VotoDetalhadoDTO;
import br.com.compasso.gerenciador.converter.VotoConverter;
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
		return votos.map(votoConverter::toVotoDetalhadoDTO).orElseThrow(NoSuchElementException::new);
	}

	public void save(Voto voto) {
		votoRepository.save(voto);
	}
}
