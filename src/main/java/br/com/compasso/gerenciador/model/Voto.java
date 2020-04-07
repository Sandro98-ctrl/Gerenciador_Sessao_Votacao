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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associado == null) ? 0 : associado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (associado == null) {
			if (other.associado != null)
				return false;
		} else if (!associado.equals(other.associado))
			return false;
		return true;
	}

}
