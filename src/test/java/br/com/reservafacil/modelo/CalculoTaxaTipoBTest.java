package br.com.reservafacil.modelo;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.com.reservafacil.modelo.taxa.CalculadorTaxa;
import br.com.reservafacil.modelo.transferencia.TipoTransferencia;
import br.com.reservafacil.modelo.transferencia.Transferencia;

public class CalculoTaxaTipoBTest {
	
	private Transferencia transferencia; 

	@Before
	public void iniciarSimulacaoTransferencia() {
		transferencia = new Transferencia();
		transferencia.setContaDestino("88057-5");
		transferencia.setContaOrigem("88057-4");
		transferencia.setValor(new BigDecimal("150"));
		transferencia.setDataCadastro(LocalDate.now());
		transferencia.setTipo(TipoTransferencia.B);
	}
	
	@Test
	public void calcularValorTaxaTipoBParaAgendamentoComMaisTrintaDias () {
		transferencia.setDataAgendamento(LocalDate.parse("2016-08-20"));
		transferencia.setTaxa(CalculadorTaxa.getInstance(transferencia)
				.valorCalculado());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal(8)) == 0); 
	}
	
	@Test
	public void calcularValorTaxaTipoBParaAgendamentoComAteTrintaDias () {
		transferencia.setDataAgendamento(LocalDate.parse("2016-11-20"));
		transferencia.setTaxa(CalculadorTaxa.getInstance(transferencia)
				.valorCalculado());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal(10)) == 0); 
	}

}
