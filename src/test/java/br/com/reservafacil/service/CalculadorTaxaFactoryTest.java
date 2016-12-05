package br.com.reservafacil.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.reservafacil.model.Transferencia;
import br.com.reservafacil.model.enumeration.TipoTransferencia;
import br.com.reservafacil.service.factory.CalculadorTaxaFactory;
import br.com.reservafacil.service.interfaces.TipoCalculo;

public class CalculadorTaxaFactoryTest {

	private Transferencia transferencia; 
	
	@Before
	public void iniciarSimulacaoTransferencia() {
		transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal("150"));
	}
	
	@Test
	public void deveRetornarUmaInstanciaTipoCalculoA() {
		transferencia.setTipo(TipoTransferencia.A);
		
		TipoCalculo tipoCalculo = CalculadorTaxaFactory.getInstance().getTipoCalculoPorTransferencia(transferencia); 

		assertTrue(tipoCalculo instanceof TipoCalculoAService);
		
		assertFalse(tipoCalculo instanceof TipoCalculoCService);
		assertFalse(tipoCalculo instanceof TipoCalculoBService);
		assertFalse(tipoCalculo instanceof TipoCalculoDService);
	}
	
	@Test
	public void deveRetornarUmaInstanciaTipoCalculoB() {
		transferencia.setTipo(TipoTransferencia.B);
		
		TipoCalculo tipoCalculo = CalculadorTaxaFactory.getInstance().getTipoCalculoPorTransferencia(transferencia); 

		assertTrue(tipoCalculo instanceof TipoCalculoBService);
		
		assertFalse(tipoCalculo instanceof TipoCalculoCService);
		assertFalse(tipoCalculo instanceof TipoCalculoAService);
		assertFalse(tipoCalculo instanceof TipoCalculoDService);
	}
	
	@Test
	public void deveRetornarUmaInstanciaTipoCalculoC() {
		transferencia.setTipo(TipoTransferencia.C);
		
		TipoCalculo tipoCalculo = CalculadorTaxaFactory.getInstance().getTipoCalculoPorTransferencia(transferencia); 

		assertTrue(tipoCalculo instanceof TipoCalculoCService);
		
		assertFalse(tipoCalculo instanceof TipoCalculoBService);
		assertFalse(tipoCalculo instanceof TipoCalculoAService);
		assertFalse(tipoCalculo instanceof TipoCalculoDService);
	}
	
	@Test
	public void deveRetornarUmaInstanciaCorretaBaseadoRegraTipoCalculoD() {
		transferencia.setTipo(TipoTransferencia.D);
		
		transferencia.setValor(new BigDecimal("25000"));
		TipoCalculo tipoCalculoA = CalculadorTaxaFactory.getInstance().getTipoCalculoPorTransferencia(transferencia); 
		assertTrue(tipoCalculoA instanceof TipoCalculoAService);
		
		transferencia.setValor(new BigDecimal("30000"));
		TipoCalculo tipoCalculoB = CalculadorTaxaFactory.getInstance().getTipoCalculoPorTransferencia(transferencia); 
		assertTrue(tipoCalculoB instanceof TipoCalculoBService);
		
		transferencia.setValor(new BigDecimal("130000"));
		TipoCalculo tipoCalculoC = CalculadorTaxaFactory.getInstance().getTipoCalculoPorTransferencia(transferencia); 
		assertTrue(tipoCalculoC instanceof TipoCalculoCService);
	}
	
}
