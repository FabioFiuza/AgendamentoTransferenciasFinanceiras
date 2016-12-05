package br.com.reservafacil.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;

import br.com.reservafacil.model.Transferencia;
import br.com.reservafacil.service.interfaces.TipoCalculo;

public class TipoCalculoCService implements TipoCalculo {

	@Override
	public BigDecimal calcularTaxa(Transferencia transferencia) {
		long diferenca = ChronoUnit.DAYS.between(transferencia.getDataAgendamento(), transferencia.getDataCadastro());
		
		BigDecimal taxa = BigDecimal.ZERO;
		
		if(diferenca > 30) {
			taxa = transferencia.getValor().multiply(new BigDecimal("0.012"));
		
		} else 	if(diferenca > 25 && diferenca <= 30) {
			taxa = transferencia.getValor().multiply(new BigDecimal("0.021"));
		
		} else 	if(diferenca > 20 && diferenca <= 25) {
			taxa = transferencia.getValor().multiply(new BigDecimal("0.043"));
		
		} else 	if(diferenca > 15 && diferenca <= 20) {
			taxa = transferencia.getValor().multiply(new BigDecimal("0.054"));
		
		} else 	if(diferenca > 10 && diferenca <= 15) {
			taxa = transferencia.getValor().multiply(new BigDecimal("0.067"));
		
		} else 	if(diferenca > 5 && diferenca <= 10) {
			taxa = transferencia.getValor().multiply(new BigDecimal("0.074"));
		
		} else 	if(diferenca > 0 && diferenca <= 5) {
			taxa = transferencia.getValor().multiply(new BigDecimal("0.083"));
		}
		
		return taxa.setScale(2, RoundingMode.HALF_EVEN);
	}

}
