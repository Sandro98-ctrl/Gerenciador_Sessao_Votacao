package br.com.compasso.gerenciador.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.compasso.gerenciador.controller.dto.AssociadoDTO;
import br.com.compasso.gerenciador.controller.form.AssociadoForm;
import br.com.compasso.gerenciador.converter.AssociadoConverter;
import br.com.compasso.gerenciador.exception.AssociadoNotFoundException;
import br.com.compasso.gerenciador.model.Associado;
import br.com.compasso.gerenciador.repository.AssociadoRepository;

@RunWith(MockitoJUnitRunner.class)
class AssociadoServiceTest {

	@InjectMocks
	private AssociadoService associadoService;

	@Mock
	private AssociadoRepository associadoRepository;

	@Mock
	private AssociadoConverter associadoConverter;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void cadastrarTest() {

		var form = Mockito.mock(AssociadoForm.class);
		var associado = Mockito.mock(Associado.class);
//		var associadoDTO = new AssociadoDTO(new Associado("123", "Sandro"));
		var associadoDTO = new AssociadoDTO();

		Mockito.when(associadoConverter.toAssociado(form)).thenReturn(associado);
		Mockito.when(associadoConverter.toAssociadoDTO(associado)).thenReturn(associadoDTO);

		associadoService.cadastrar(form);

		Mockito.verify(associadoRepository).save(associado);
		assertTrue(!associadoDTO.getCpf().isEmpty());
	}

	@Test
	void getByIdTest() {

		var associado = Mockito.mock(Associado.class);
//		var associadoDTO = new AssociadoDTO(new Associado("456", "Sandro"));
		var associadoDTO = new AssociadoDTO();

		Mockito.when(associadoConverter.toAssociadoDTO(associado)).thenReturn(associadoDTO);
		Mockito.when(associadoRepository.findById("5e8ddb2dc6f9f5243429fde1")).thenReturn(Optional.of(associado));

		var associadoDTO2 = associadoService.getById("5e8ddb2dc6f9f5243429fde1");

		Mockito.verify(associadoConverter).toAssociadoDTO(associado);
		assertEquals(associadoDTO, associadoDTO2);
	}

	@Test(expected = AssociadoNotFoundException.class)
	void getByIdTestException() {

		var associado = Mockito.mock(Associado.class);
//		var associadoDTOMockado = new AssociadoDTO(new Associado("456", "Sandro"));
		var associadoDTOMockado = new AssociadoDTO();

		Mockito.when(associadoConverter.toAssociadoDTO(associado)).thenReturn(associadoDTOMockado);
		Mockito.doThrow(new AssociadoNotFoundException()).when(associadoRepository)
				.findById("5e8ddb2dc6f9f5243429fde1");

		associadoService.getById("5e8ddb2dc6f9f5243429fde1");

		Mockito.verify(associadoRepository).findById("5e8ddb2dc6f9f5243429fde1");
	}

}
