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
		return ResponseEntity.ok(SessaoCompletaDTO.convert(lista));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable String id){
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}/resultados")
	public ResponseEntity<?> resultados(){
		return null;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<SessaoCriadaDTO> cadastrar(@RequestBody @Valid SessaoForm form, UriComponentsBuilder uriBuilder){
		var sessao = sessaoBusiness.toSessao(form);
		sessaoBusiness.save(sessao);
		var uri = uriBuilder.path("/sessoes/{id}").buildAndExpand(sessao.getId()).toUri();
		return ResponseEntity.created(uri).body(new SessaoCriadaDTO(sessao));
	}
	
	@PostMapping("/{id}/votar")
	@Transactional
	public ResponseEntity<?> votar(@RequestBody @Valid VotoForm form, @PathVariable String id){
		sessaoBusiness.votar(form, id);
		return ResponseEntity.ok().build();
	}
}
