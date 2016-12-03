package br.com.reservafacil.modelo.tipocalculo;

import java.math.BigDecimal;

import br.com.reservafacil.modelo.transferencia.Transferencia;

public interface TipoCalculo {
	
	public BigDecimal calcularTaxa(Transferencia transferencia); 

}
