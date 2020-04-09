package br.com.compasso.gerenciador.config.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;

import br.com.compasso.gerenciador.model.Voto;

public class VotoCascadeSaveMongoEventListener extends AbstractMongoEventListener<Object> {

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public void onAfterSave(AfterSaveEvent<Object> event) {
		var source = event.getSource();

		if (source instanceof Voto) {
			var voto = (Voto) source;

			if (voto.getSessao() != null) {
				mongoOperations.save(voto.getSessao());
			}
		}
	}

}
