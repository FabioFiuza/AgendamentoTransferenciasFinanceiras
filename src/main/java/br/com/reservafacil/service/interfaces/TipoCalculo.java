package br.com.reservafacil.service.interfaces;

import java.math.BigDecimal;

import br.com.reservafacil.model.Transferencia;

public interface TipoCalculo {
	
	public BigDecimal calcularTaxa(Transferencia transferencia); 

}
