package br.com.reservafacil.service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

import br.com.reservafacil.model.Transferencia;
import br.com.reservafacil.service.interfaces.TipoCalculo;

public class TipoCalculoBService implements TipoCalculo {

	@Override
	public BigDecimal calcularTaxa(Transferencia transferencia) {
		long diferenca = ChronoUnit.DAYS.between(transferencia.getDataAgendamento(), transferencia.getDataCadastro());
		
		if(agendamentoNaoExcedeTrintaDias(diferenca)) {
			return new BigDecimal("10"); 
		}
		
		return new BigDecimal("8");
	}

	private boolean agendamentoNaoExcedeTrintaDias(long diferenca) {
		return diferenca <= 30;
	}

}
