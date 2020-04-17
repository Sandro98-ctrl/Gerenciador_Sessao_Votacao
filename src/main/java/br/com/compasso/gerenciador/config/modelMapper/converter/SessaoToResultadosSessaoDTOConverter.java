package br.com.compasso.gerenciador.config.modelMapper.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import br.com.compasso.gerenciador.controller.dto.ResultadosSessaoDTO;
import br.com.compasso.gerenciador.model.Sessao;
import br.com.compasso.gerenciador.util.ContabilizadorDeVotos;

public class SessaoToResultadosSessaoDTOConverter implements Converter<Sessao, ResultadosSessaoDTO> {

	@Override
	public ResultadosSessaoDTO convert(MappingContext<Sessao, ResultadosSessaoDTO> context) {
		var sessao = context.getSource();
		var resultadoSessaoDTO = new ResultadosSessaoDTO();
		var contabilizador = new ContabilizadorDeVotos(sessao.getVotos());
		resultadoSessaoDTO.setEstadoSessao(sessao.getEstado());
		resultadoSessaoDTO.setTotalVotos(contabilizador.totalDeVotos());
		resultadoSessaoDTO.setVotosAFavor(contabilizador.votosAFavor());
		resultadoSessaoDTO.setVotosContra(contabilizador.votosContra());
		return resultadoSessaoDTO;
	}
	
}
