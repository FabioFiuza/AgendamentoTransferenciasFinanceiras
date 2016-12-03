package br.com.reservafacil.modelo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.com.reservafacil.modelo.transferencia.TipoTransferencia;
import br.com.reservafacil.modelo.transferencia.Transferencia;

public class TaxaTransferenciaTest {
	
	private Transferencia transferencia; 
	
	@Before
	public void iniciarSimulacaoTransferencia() {
		transferencia = new Transferencia();
		transferencia.setContaDestino("88057-5");
		transferencia.setContaOrigem("88057-4");
		transferencia.setValor(new BigDecimal("150"));
		transferencia.setDataAgendamento(LocalDate.parse("2016-11-20"));
		transferencia.setDataCadastro(LocalDate.now());
	}
	
	@Test
	public void calcularValorTaxaTipoA() {
		transferencia.setTipo(TipoTransferencia.A);
		transferencia.setTaxa(CalculadorTaxa.getInstance(transferencia)
				.valorCalculado()); 		

		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal(6.5)) == 0);
	}
	
	@Test
	public void calcularValorTaxaTipoBParaAgendamentoComMaisTrintaDias () {
		transferencia.setTipo(TipoTransferencia.B);
		transferencia.setDataAgendamento(LocalDate.parse("2016-08-20"));
		transferencia.setTaxa(CalculadorTaxa.getInstance(transferencia)
				.valorCalculado());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal(8)) == 0); 
	}
	
	@Test
	public void calcularValorTaxaTipoBParaAgendamentoComAteTrintaDias () {
		transferencia.setTipo(TipoTransferencia.B);
		transferencia.setDataAgendamento(LocalDate.parse("2016-11-20"));
		transferencia.setTaxa(CalculadorTaxa.getInstance(transferencia)
				.valorCalculado());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal(10)) == 0); 
	}
	
	@Test
	public void calcularValorTaxaParaTransferenciaTipoCParaAgendamentosMaiorTrintaDias () {
		transferencia.setTipo(TipoTransferencia.C);
		transferencia.setDataAgendamento(LocalDate.parse("2016-01-20"));
		transferencia.setTaxa(CalculadorTaxa.getInstance(transferencia)
				.valorCalculado());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal("1.80")) == 0); 
	}
	
}
