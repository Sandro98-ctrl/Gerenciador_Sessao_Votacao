package br.com.compasso.gerenciador.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "votos")
@TypeAlias("Voto")
public class Voto {

	@Id
	private String id;
	private OpcaoVoto opcaoVoto;
	@DBRef
	private Associado associado;

	public Voto(OpcaoVoto opcaoVoto, Associado associado) {
		this.opcaoVoto = opcaoVoto;
		this.associado = associado;
	}
	
	public String getId() {
		return id;
	}

	public OpcaoVoto getOpcaoVoto() {
		return opcaoVoto;
	}

	public Associado getAssociado() {
		return associado;
	}

}
