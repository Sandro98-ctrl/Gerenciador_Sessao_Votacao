package br.com.compasso.gerenciador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.gerenciador.model.Pauta;

@Repository
public interface PautaRepository extends MongoRepository<Pauta, String> {
	
}
