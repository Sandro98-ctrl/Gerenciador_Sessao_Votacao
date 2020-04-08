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

import br.com.compasso.gerenciador.controller.dto.PautaDTO;
import br.com.compasso.gerenciador.controller.form.PautaForm;
import br.com.compasso.gerenciador.service.PautaService;

@RestController
@RequestMapping("/pautas")
public class PautaController {

	private final PautaService pautaService;

	public PautaController(PautaService pautaService) {
		this.pautaService = pautaService;
	}

	@GetMapping
	public ResponseEntity<Collection<PautaDTO>> list() {
		var listaDTO = pautaService.getAll();
		return ResponseEntity.ok(listaDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PautaDTO> getOne(@PathVariable String id) {
		var pautaDTO = pautaService.getById(id);
		return ResponseEntity.ok(pautaDTO);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PautaDTO> cadastrar(@RequestBody @Valid PautaForm form, UriComponentsBuilder uriBuilder) {
		var pautaDTO = pautaService.cadastrar(form);
		var uri = uriBuilder.path("/pautas/{id}").buildAndExpand(pautaDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(pautaDTO);
	}

}
