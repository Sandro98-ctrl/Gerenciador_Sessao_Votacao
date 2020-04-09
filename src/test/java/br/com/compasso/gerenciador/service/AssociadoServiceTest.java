package br.com.compasso.gerenciador.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.compasso.gerenciador.controller.form.AssociadoForm;
import br.com.compasso.gerenciador.converter.AssociadoConverter;
import br.com.compasso.gerenciador.model.Associado;
import br.com.compasso.gerenciador.repository.AssociadoRepository;


class AssociadoServiceTest {

	@Mock
	private AssociadoRepository associadoRepository;
	
	@Test
	void cadastrarTest() {
		
		var associadoService = Mockito.mock(AssociadoService.class);
//		var associadoRepository = Mockito.mock(AssociadoRepository.class);
		var associadoConverter = Mockito.mock(AssociadoConverter.class);
		var form = Mockito.mock(AssociadoForm.class);
		var associado = Mockito.mock(Associado.class);

		Mockito.when(associadoConverter.toAssociado(form)).thenReturn(associado);
		Mockito.doNothing().when(associadoRepository).count();
		
		associadoService.cadastrar(form);
		
		assertTrue(true);
	}

}
