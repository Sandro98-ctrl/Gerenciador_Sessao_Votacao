package br.com.compasso.gerenciador.config.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.compasso.gerenciador.config.modelMapper.converter.SessaoToResultadosSessaoDTOConverter;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(new SessaoToResultadosSessaoDTOConverter());
		return modelMapper;
	}
	
}
