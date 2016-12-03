package br.com.reservafacil.modelo;

import java.math.BigDecimal;

public class CalculadorTaxa {
	
	private TipoTransferencia tipoTransferencia;
	private BigDecimal valorTrasnferencia; 
	private TipoCalculo tipoCalculo;
	
	public static CalculadorTaxa getInstance(TipoTransferencia tipoTransferencia, BigDecimal valorTrasnferencia) {
		CalculadorTaxa calculador = new CalculadorTaxa();
		calculador.setTipoTransferencia(tipoTransferencia);
		calculador.setValorTrasnferencia(valorTrasnferencia);
		
		return calculador;
	}
	
	/**
	 * Metodo responsavel por devolver o valor baseado no tipo de transferencia escolhida
	 * @return retorna o valor da taxa da transferencia
	 */
	
	public BigDecimal valorCalculado() {
		if(tipoTransferencia == TipoTransferencia.A) {
			tipoCalculo = new CalculoTipoA(); 
		
		} else if(tipoTransferencia == TipoTransferencia.B) {
			tipoCalculo = new CalculoTipoB(); 

		} else if(tipoTransferencia == TipoTransferencia.C) {
			tipoCalculo = new CalculoTipoC(); 
		} 
		
		return tipoCalculo.calcularTaxa(valorTrasnferencia);
	}
	
	private void setTipoTransferencia(TipoTransferencia tipoTransferencia) {
		this.tipoTransferencia = tipoTransferencia;
	}
	
	private void setValorTrasnferencia(BigDecimal valorTrasnferencia) {
		this.valorTrasnferencia = valorTrasnferencia;
	}

}
