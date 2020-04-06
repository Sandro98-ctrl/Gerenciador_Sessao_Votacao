package br.com.compasso.gerenciador.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.gerenciador.controller.dto.VotoDetalhadoDTO;
import br.com.compasso.gerenciador.service.VotoService;

@RestController
@RequestMapping("/votos")
public class VotoController {

	private final VotoService votoService;
	
	public VotoController(VotoService votoService) {
		this.votoService = votoService;
	}
	
	@GetMapping
	public ResponseEntity<Collection<VotoDetalhadoDTO>> list(){
		var listaDTO = votoService.getAll();
		return ResponseEntity.ok(listaDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VotoDetalhadoDTO> getOne(@PathVariable String id){
		var votoDTO = votoService.getById(id);
		return ResponseEntity.ok(votoDTO);
	}
}
