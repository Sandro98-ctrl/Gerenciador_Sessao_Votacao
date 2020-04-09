package br.com.compasso.gerenciador.util;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.compasso.gerenciador.service.SessaoService;

@Component
@EnableScheduling
public class VerificadorDeSessoesExpiradas {

	private static final String TIME_ZONE = "America/Sao_Paulo";
	private final SessaoService sessaoService;

	public VerificadorDeSessoesExpiradas(SessaoService sessaoService) {
		this.sessaoService = sessaoService;
	}

	@Scheduled(fixedDelay = 5000, zone = TIME_ZONE)
	@Transactional
	public void verificar() {
		sessaoService.encerraSessoesExpiradas();
	}
}
