package br.com.compasso.gerenciador.config.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

	@Bean
	public VotoCascadeSaveMongoEventListener votoCascadeSaveMongoEventListener() {
		return new VotoCascadeSaveMongoEventListener();
	}
}
