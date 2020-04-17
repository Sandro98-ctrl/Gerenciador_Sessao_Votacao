package br.com.compasso.gerenciador.service;

import java.util.Arrays;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.AssociadoDTO;
import br.com.compasso.gerenciador.controller.form.AssociadoForm;
import br.com.compasso.gerenciador.converter.AssociadoConverter;
import br.com.compasso.gerenciador.exception.AssociadoNotFoundException;
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

	public Collection<AssociadoDTO> getAll() {
		var associados = associadoRepository.findAll();
		return associadoConverter.toAssociadoDTOCollection(associados);
	}

	public AssociadoDTO getById(String id) {
		var associado = getOne(id);
		return associadoConverter.toAssociadoDTO(associado);
	}

	public Associado getOne(String id) {
		var associado = associadoRepository.findById(id);
		return associado.orElseThrow(AssociadoNotFoundException::new);
	}

	public AssociadoDTO cadastrar(AssociadoForm form) {
		var associado = associadoConverter.toAssociado(form);
		associadoRepository.save(associado);
		return associadoConverter.toAssociadoDTO(associado);
	}
}
