package br.com.compasso.gerenciador.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.gerenciador.controller.dto.AssociadoDTO;
import br.com.compasso.gerenciador.controller.form.AssociadoForm;
import br.com.compasso.gerenciador.service.AssociadoService;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

	private final AssociadoService associadoService;

	public AssociadoController(AssociadoService associadoService) {
		this.associadoService = associadoService;
	}

	@GetMapping
	public ResponseEntity<Collection<AssociadoDTO>> list() {
		var listaDTO = associadoService.getAll();
		return ResponseEntity.ok(listaDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AssociadoDTO> getOne(@PathVariable String id) {
		var associadoDTO = associadoService.getById(id);
		return ResponseEntity.ok(associadoDTO);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AssociadoDTO> cadastrar(@RequestBody @Valid AssociadoForm form, UriComponentsBuilder uriBuilder) {
		var associadoDTO = associadoService.cadastrar(form);
		var uri = uriBuilder.path("/associados/{id}").buildAndExpand(associadoDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(associadoDTO);
	}
}
