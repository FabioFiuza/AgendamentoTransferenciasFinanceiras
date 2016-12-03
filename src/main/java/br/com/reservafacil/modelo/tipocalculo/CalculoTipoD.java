package br.com.reservafacil.modelo.tipocalculo;

import java.math.BigDecimal;

public class CalculoTipoD {
	
	public static TipoCalculo getTipoCalculoBaseadoValorTransfenrecia(BigDecimal valorTransferencia) {
		TipoCalculo tipoCalculo = null; 
		
		if(valorTransferenciaAteVinteCincoMil(valorTransferencia)) {
			tipoCalculo = new CalculoTipoA();
		
		} else if (valorTransferenciaEntreVinteCincoMilEhUmAteDozeMil(valorTransferencia) ) {
			tipoCalculo = new CalculoTipoB();
		
		} else if (valorTransferenciaMaiorQueDozeMil(valorTransferencia)) {
			tipoCalculo = new CalculoTipoC();
		}
		
		return tipoCalculo; 
	}

	private static boolean valorTransferenciaMaiorQueDozeMil(BigDecimal valorTransferencia) {
		return valorTransferencia.compareTo(new BigDecimal("12000")) > 0;
	}

	private static boolean valorTransferenciaEntreVinteCincoMilEhUmAteDozeMil(BigDecimal valorTransferencia) {
		return valorTransferencia.compareTo(new BigDecimal("25001")) > 0 && 
				valorTransferencia.compareTo(new BigDecimal("12000")) <= 0;
	}

	private static boolean valorTransferenciaAteVinteCincoMil(BigDecimal valorTransferencia) {
		return valorTransferencia.compareTo(new BigDecimal("25000")) <= 0;
	}

}
