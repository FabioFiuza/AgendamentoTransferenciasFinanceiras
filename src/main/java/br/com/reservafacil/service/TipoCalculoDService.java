package br.com.reservafacil.service;

import java.math.BigDecimal;

import br.com.reservafacil.service.interfaces.TipoCalculo;

public class TipoCalculoDService {
	
	public static TipoCalculo getTipoCalculoBaseadoValorTransfenrecia(BigDecimal valorTransferencia) {
		TipoCalculo tipoCalculo = null; 
		
		if(valorTransferenciaAteVinteCincoMil(valorTransferencia)) {
			tipoCalculo = new TipoCalculoAService();
		
		} else if (valorTransferenciaEntreVinteCincoMilEhUmAteCentoVinteMil(valorTransferencia) ) {
			tipoCalculo = new TipoCalculoBService();
		
		} else if (valorTransferenciaMaiorQueCentoVinteMil(valorTransferencia)) {
			tipoCalculo = new TipoCalculoCService();
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
