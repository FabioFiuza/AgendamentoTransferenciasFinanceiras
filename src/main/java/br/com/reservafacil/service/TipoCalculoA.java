package br.com.reservafacil.service;

import java.math.BigDecimal;

import br.com.reservafacil.modelo.Transferencia;
import br.com.reservafacil.service.interfaces.TipoCalculo;

public class TipoCalculoA implements TipoCalculo {

	@Override
	public BigDecimal calcularTaxa(Transferencia transferencia) {
		BigDecimal valorFixo = new BigDecimal("2");
		BigDecimal valorPercentual = transferencia.getValor().multiply(new BigDecimal("0.03")); 
		
		return valorFixo.add(valorPercentual);
	}

}
