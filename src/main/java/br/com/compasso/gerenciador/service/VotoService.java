package br.com.compasso.gerenciador.service;

import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.controller.dto.VotoCriadoDTO;
import br.com.compasso.gerenciador.controller.dto.VotoDetalhadoDTO;
import br.com.compasso.gerenciador.controller.form.VotoForm;
import br.com.compasso.gerenciador.converter.VotoConverter;
import br.com.compasso.gerenciador.exception.VotoNotFoundException;
import br.com.compasso.gerenciador.repository.VotoRepository;

@Service
public class VotoService {

	private final VotoRepository votoRepository;
	private final VotoConverter votoConverter;
	private final ModelMapper modelMapper;

	public VotoService(VotoRepository votoRepository, VotoConverter votoConverter, ModelMapper modelMapper) {
		this.votoRepository = votoRepository;
		this.votoConverter = votoConverter;
		this.modelMapper = modelMapper;
	}
	
	public Collection<VotoDetalhadoDTO> getAll(){
		var votos = votoRepository.findAll();
		return votoConverter.toVotoDetalhadoDTOCollection(votos);
	}
	
	public VotoDetalhadoDTO getById(String id){
		var voto = votoRepository.findById(id);
		return voto.map(v -> modelMapper.map(v, VotoDetalhadoDTO.class)).orElseThrow(VotoNotFoundException::new);
	}

	public VotoCriadoDTO cadastrar(VotoForm form, AssociadoService associadoService, SessaoService sessaoService) {
		var voto =  votoConverter.toVoto(form, associadoService, sessaoService);
		votoRepository.save(voto);
		return votoConverter.toVotoCriadoDTO(voto);
	}
}
