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

import br.com.compasso.gerenciador.business.VotoBusiness;
import br.com.compasso.gerenciador.controller.dto.VotoCriadoDTO;
import br.com.compasso.gerenciador.controller.dto.VotoDetalhadoDTO;
import br.com.compasso.gerenciador.controller.form.VotoForm;

@RestController
@RequestMapping("/votos")
public class VotoController {

	private final VotoBusiness votoBusiness;

	public VotoController(VotoBusiness votoBusiness) {
		this.votoBusiness = votoBusiness;
	}

	@GetMapping
	public ResponseEntity<Collection<VotoDetalhadoDTO>> list() {
		var listaDTO = votoBusiness.getAll();
		return ResponseEntity.ok(listaDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<VotoDetalhadoDTO> getOne(@PathVariable String id) {
		var votoDTO = votoBusiness.getById(id);
		return ResponseEntity.ok(votoDTO);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<VotoCriadoDTO> votar(@RequestBody @Valid VotoForm form, UriComponentsBuilder uriBuilder){
		var votoDTO = votoBusiness.cadastrar(form);
		var uri = uriBuilder.path("/votos/{id}").buildAndExpand(votoDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(votoDTO);
	}
}
