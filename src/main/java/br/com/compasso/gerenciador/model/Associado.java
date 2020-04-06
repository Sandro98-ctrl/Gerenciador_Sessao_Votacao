package br.com.compasso.gerenciador.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "associados")
@TypeAlias("Associado")
public class Associado {

	private String id;
	private String cpf;
	private String nome;
	
	public Associado(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}
	
	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

}
