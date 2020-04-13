package br.com.compasso.gerenciador.service;

import java.util.Collection;

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
		return votos.map(votoConverter::toVotoDetalhadoDTO).orElseThrow(VotoNotFoundException::new);
	}

	public VotoCriadoDTO cadastrar(VotoForm form, AssociadoService associadoService, SessaoService sessaoService) {
		var voto =  votoConverter.toVoto(form, associadoService, sessaoService);
		voto.verificaSessaoExpirada();
		votoRepository.save(voto);
		return votoConverter.toVotoCriadoDTO(voto);
	}
}
