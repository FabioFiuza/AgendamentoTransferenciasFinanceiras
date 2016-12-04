package br.com.reservafacil.service;

import java.math.BigDecimal;

import br.com.reservafacil.modelo.Transferencia;
import br.com.reservafacil.modelo.enumeration.TipoTransferencia;
import br.com.reservafacil.service.interfaces.TipoCalculo;

public class CalculadorTaxaService {
	
	private Transferencia transferencia;
	private TipoCalculo tipoCalculo;
	
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
	
	public BigDecimal valorCalculado() {
		if(transferencia.getTipo() == TipoTransferencia.A) {
			tipoCalculo = new TipoCalculoA(); 
		
		} else if(transferencia.getTipo() == TipoTransferencia.B) {
			tipoCalculo = new TipoCalculoB(); 

		} else if(transferencia.getTipo() == TipoTransferencia.C) {
			tipoCalculo = new TipoCalculoC(); 
		
		} else if(transferencia.getTipo() == TipoTransferencia.D) {
			tipoCalculo = TipoCalculoD.getTipoCalculoBaseadoValorTransfenrecia(transferencia.getValor()); 	
		}
		
		return tipoCalculo.calcularTaxa(transferencia);
	}

}
