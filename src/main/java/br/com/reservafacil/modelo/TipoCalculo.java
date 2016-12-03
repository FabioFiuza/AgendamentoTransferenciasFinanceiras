package br.com.reservafacil.modelo;

import java.math.BigDecimal;

public interface TipoCalculo {
	
	public BigDecimal calcularTaxa(BigDecimal valorTrasnferencia); 

}
