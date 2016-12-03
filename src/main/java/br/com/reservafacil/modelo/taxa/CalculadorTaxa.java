package br.com.reservafacil.modelo.taxa;

import java.math.BigDecimal;

import br.com.reservafacil.modelo.tipocalculo.TipoCalculoA;
import br.com.reservafacil.modelo.tipocalculo.TipoCalculoB;
import br.com.reservafacil.modelo.tipocalculo.TipoCalculoC;
import br.com.reservafacil.modelo.tipocalculo.TipoCalculoD;
import br.com.reservafacil.modelo.tipocalculo.TipoCalculo;
import br.com.reservafacil.modelo.transferencia.TipoTransferencia;
import br.com.reservafacil.modelo.transferencia.Transferencia;

public class CalculadorTaxa {
	
	private Transferencia transferencia;
	private TipoCalculo tipoCalculo;
	
	public static CalculadorTaxa getInstance(Transferencia transferencia) {
		CalculadorTaxa calculador = new CalculadorTaxa();
		calculador.setTransferencia(transferencia);
		
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
