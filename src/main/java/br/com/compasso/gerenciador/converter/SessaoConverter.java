package br.com.compasso.gerenciador.converter;

import org.springframework.stereotype.Component;

import br.com.compasso.gerenciador.controller.form.SessaoForm;
import br.com.compasso.gerenciador.model.Sessao;
import br.com.compasso.gerenciador.service.PautaService;

@Component
public class SessaoConverter {

	public Sessao toSessao(SessaoForm form, PautaService pautaService) {
		var pauta = pautaService.getPautaById(form.getPautaId());
		var sessao = new Sessao();
		
		if(form.getDataHoraTermino() != null) {
			sessao.setDataHoraTermino(form.getDataHoraTermino());
		}
		
		sessao.setPauta(pauta);
		return sessao;
	}
	
}
