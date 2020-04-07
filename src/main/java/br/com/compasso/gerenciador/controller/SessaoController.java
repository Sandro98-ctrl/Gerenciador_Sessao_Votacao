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

import br.com.compasso.gerenciador.business.SessaoBusiness;
import br.com.compasso.gerenciador.controller.dto.ResultadosSessaoDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCompletaDTO;
import br.com.compasso.gerenciador.controller.dto.SessaoCriadaDTO;
import br.com.compasso.gerenciador.controller.form.SessaoForm;
import br.com.compasso.gerenciador.controller.form.VotoForm;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {

	private final SessaoBusiness sessaoBusiness;
	
	public SessaoController(SessaoBusiness sessaoBusiness) {
		this.sessaoBusiness = sessaoBusiness;
	}
	
	@GetMapping
	public ResponseEntity<Collection<SessaoCompletaDTO>> list(){
		var lista = sessaoBusiness.getAllSessoes();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SessaoCompletaDTO> getOne(@PathVariable String id){
		var sessaoDTO = sessaoBusiness.getById(id);
		return ResponseEntity.ok(sessaoDTO);
	}
	
	@GetMapping("/{id}/resultados")
	public ResponseEntity<ResultadosSessaoDTO> resultados(@PathVariable String id){
		var resultados = sessaoBusiness.getResultadosDaSessao(id);
		return ResponseEntity.ok(resultados);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<SessaoCriadaDTO> cadastrar(@RequestBody @Valid SessaoForm form, UriComponentsBuilder uriBuilder){
		var sessaoDTO = sessaoBusiness.cadastrar(form);
		var uri = uriBuilder.path("/sessoes/{id}").buildAndExpand(sessaoDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(sessaoDTO);
	}
	
	@PostMapping("/{id}/votar")
	@Transactional
	public ResponseEntity<?> votar(@RequestBody @Valid VotoForm form, @PathVariable String id){
		sessaoBusiness.votar(form, id);
		return ResponseEntity.ok().build();
	}
}
