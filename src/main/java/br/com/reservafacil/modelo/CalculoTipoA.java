package br.com.reservafacil.modelo;

import java.math.BigDecimal;

public class CalculoTipoA implements TipoCalculo {

	@Override
	public BigDecimal calcularTaxa(BigDecimal valorTrasnferencia) {
		BigDecimal valorFixo = new BigDecimal("2");
		BigDecimal valorPercentual = valorTrasnferencia.multiply(new BigDecimal("0.03")); 
		
		return valorFixo.add(valorPercentual);
	}

}
