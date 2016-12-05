package br.com.reservafacil.service.factory;

import br.com.reservafacil.model.Transferencia;
import br.com.reservafacil.model.enumeration.TipoTransferencia;
import br.com.reservafacil.service.TipoCalculoAService;
import br.com.reservafacil.service.TipoCalculoBService;
import br.com.reservafacil.service.TipoCalculoCService;
import br.com.reservafacil.service.TipoCalculoDService;
import br.com.reservafacil.service.interfaces.TipoCalculo;

public class CalculadorTaxaFactory {
	
	private TipoCalculo tipoCalculo;
	
	public static CalculadorTaxaFactory getInstance() {
		return new CalculadorTaxaFactory(); 
	}
	
	public TipoCalculo getTipoCalculoPorTransferencia(Transferencia transferencia) {
		if(transferencia.getTipo() == TipoTransferencia.A) {
			tipoCalculo = new TipoCalculoAService(); 
		
		} else if(transferencia.getTipo() == TipoTransferencia.B) {
			tipoCalculo = new TipoCalculoBService(); 

		} else if(transferencia.getTipo() == TipoTransferencia.C) {
			tipoCalculo = new TipoCalculoCService(); 
		
		} else if(transferencia.getTipo() == TipoTransferencia.D) {
			tipoCalculo = TipoCalculoDService.getTipoCalculoBaseadoValorTransfenrecia(transferencia.getValor()); 	
		}
		
		return tipoCalculo;
	}
	
}
