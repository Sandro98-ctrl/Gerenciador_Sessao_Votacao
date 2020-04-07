package br.com.compasso.gerenciador.service;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.AssociadoDTO;
import br.com.compasso.gerenciador.converter.AssociadoConverter;
import br.com.compasso.gerenciador.model.Associado;
import br.com.compasso.gerenciador.repository.AssociadoRepository;

@Service
public class AssociadoService {

	private final AssociadoRepository associadoRepository;
	private final AssociadoConverter associadoConverter;

	public AssociadoService(AssociadoRepository associadoRepository, AssociadoConverter associadoConverter) {
		this.associadoRepository = associadoRepository;
		this.associadoConverter = associadoConverter;
	}
	
	public Collection<AssociadoDTO> getAll(){
		var lista = associadoRepository.findAll();
		return associadoConverter.toAssociadoDTOCollection(lista);
	}
	
	public AssociadoDTO getById(String id) {
		var associado = associadoRepository.findById(id);
		return associado.map(associadoConverter::toAssociadoDTO).orElseThrow(NoSuchElementException::new);
	}
	
	public Associado getAssociadoById(String id) {
		var associado = associadoRepository.findById(id);
		return associado.orElseThrow(NoSuchElementException::new);
	}

	public void save(Associado associado) {
		associadoRepository.save(associado);
	}
}
