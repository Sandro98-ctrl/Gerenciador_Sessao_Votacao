package br.com.compasso.gerenciador.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.compasso.gerenciador.model.EstadoSessao;
import br.com.compasso.gerenciador.model.Sessao;

public interface SessaoRepository extends MongoRepository<Sessao, String>{
	
	List<Sessao> findByEstado(EstadoSessao sessao);
	
}
