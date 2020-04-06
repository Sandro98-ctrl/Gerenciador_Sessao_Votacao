package br.com.compasso.gerenciador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.compasso.gerenciador.model.Sessao;

public interface SessaoRepository extends MongoRepository<Sessao, String>{
	
}
