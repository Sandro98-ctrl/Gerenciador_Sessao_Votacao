package br.com.compasso.gerenciador.util;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.compasso.gerenciador.model.EstadoSessao;
import br.com.compasso.gerenciador.repository.SessaoRepository;

@Component
@EnableScheduling
public class VerificadorDeSessoesAbertas {

	private static final String TIME_ZONE = "America/Sao_Paulo";
	private final SessaoRepository sessaoRepository;

	public VerificadorDeSessoesAbertas(SessaoRepository sessaoRepository) {
		this.sessaoRepository = sessaoRepository;
	}
	
	@Scheduled(fixedDelay = 5000, zone = TIME_ZONE)
	@Transactional
	public void verificar() {
		var lista = sessaoRepository.findByEstado(EstadoSessao.ABERTA);
		System.out.println("Quantidade de sessões abertas: " + lista.size());
		if(lista.isEmpty()) return;
		
		lista.forEach(s -> {
			if(s.getDataHoraTermino().isBefore(LocalDateTime.now())) {
				s.setEstado(EstadoSessao.ENCERRADA);
				sessaoRepository.save(s);
			}
		});
	}
}
