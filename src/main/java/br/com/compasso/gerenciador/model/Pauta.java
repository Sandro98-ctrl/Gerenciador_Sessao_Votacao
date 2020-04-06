package br.com.compasso.gerenciador.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pautas")
@TypeAlias("Pauta")
public class Pauta {

	@Id
	private String id;
	private String assunto;
	private String descricao;
//	@DBRef
//	private Sessao sessao;

	public Pauta(String assunto, String descricao) {
		this.assunto = assunto;
		this.descricao = descricao;
	}

	public String getId() {
		return id;
	}

	public String getAssunto() {
		return assunto;
	}

	public String getDescricao() {
		return descricao;
	}

}
