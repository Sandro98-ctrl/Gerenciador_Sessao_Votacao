package br.com.compasso.gerenciador.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.compasso.gerenciador.model.Sessao;
import br.com.compasso.gerenciador.repository.SessaoRepository;

@Service
public class SessaoService {

	private final SessaoRepository sessaoRepository;
	
	public SessaoService(SessaoRepository sessaoRepository) {
		this.sessaoRepository = sessaoRepository;
	}
	
	public List<Sessao> getAll(){
		return sessaoRepository.findAll();
	}

	public Optional<Sessao> getById(String id) {
		return sessaoRepository.findById(id);
	}
	
	public Sessao getSessaoById(String id) {
		var sessao = sessaoRepository.findById(id);
		return sessao.orElseThrow(NoSuchElementException::new);
	}
	
	public void save(Sessao sessao) {
		sessaoRepository.save(sessao);
	}
	
}
