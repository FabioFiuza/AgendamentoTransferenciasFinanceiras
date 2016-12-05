package br.com.reservafacil.service;

import java.math.BigDecimal;

import br.com.reservafacil.model.Transferencia;
import br.com.reservafacil.service.factory.CalculadorTaxaFactory;
import br.com.reservafacil.service.interfaces.TipoCalculo;

public class CalculadorTaxaService {
	
	private Transferencia transferencia;
	
	public CalculadorTaxaService(Transferencia transferencia) {
		setTransferencia(transferencia);
	}
	
	public static CalculadorTaxaService getInstance(Transferencia transferencia) {
		CalculadorTaxaService calculador = new CalculadorTaxaService(transferencia);		
		return calculador;
	}
	
	private void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;	
	}

	/**
	 * Metodo responsavel por devolver o valor da taxa baseado no tipo de transferencia escolhida
	 * @return retorna o valor da taxa da transferencia
	 */
	
	public BigDecimal getValorTaxa() {
		TipoCalculo tipoCalculo = CalculadorTaxaFactory.getInstance().getTipoCalculoPorTransferencia(transferencia);
		return tipoCalculo.calcularTaxa(transferencia);
	}

}
