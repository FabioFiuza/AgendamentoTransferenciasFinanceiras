package br.com.reservafacil.service;

import java.math.BigDecimal;

import br.com.reservafacil.service.interfaces.TipoCalculo;

public class TipoCalculoD {
	
	public static TipoCalculo getTipoCalculoBaseadoValorTransfenrecia(BigDecimal valorTransferencia) {
		TipoCalculo tipoCalculo = null; 
		
		if(valorTransferenciaAteVinteCincoMil(valorTransferencia)) {
			tipoCalculo = new TipoCalculoA();
		
		} else if (valorTransferenciaEntreVinteCincoMilEhUmAteCentoVinteMil(valorTransferencia) ) {
			tipoCalculo = new TipoCalculoB();
		
		} else if (valorTransferenciaMaiorQueCentoVinteMil(valorTransferencia)) {
			tipoCalculo = new TipoCalculoC();
		}
		
		return tipoCalculo; 
	}

	private static boolean valorTransferenciaMaiorQueCentoVinteMil(BigDecimal valorTransferencia) {
		return valorTransferencia.compareTo(new BigDecimal("120000")) > 0;
	}

	private static boolean valorTransferenciaEntreVinteCincoMilEhUmAteCentoVinteMil(BigDecimal valorTransferencia) {
		return valorTransferencia.compareTo(new BigDecimal("25001")) > 0 && 
				valorTransferencia.compareTo(new BigDecimal("120000")) <= 0;
	}

	private static boolean valorTransferenciaAteVinteCincoMil(BigDecimal valorTransferencia) {
		return valorTransferencia.compareTo(new BigDecimal("25000")) <= 0;
	}

}
