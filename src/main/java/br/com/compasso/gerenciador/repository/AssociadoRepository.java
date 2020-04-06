package br.com.compasso.gerenciador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.gerenciador.model.Associado;

@Repository
public interface AssociadoRepository extends MongoRepository<Associado, String>{
	
}
