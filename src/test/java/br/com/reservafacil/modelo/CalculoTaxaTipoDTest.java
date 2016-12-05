package br.com.reservafacil.modelo;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.com.reservafacil.model.Transferencia;
import br.com.reservafacil.model.enumeration.TipoTransferencia;
import br.com.reservafacil.service.CalculadorTaxaService;

public class CalculoTaxaTipoDTest {
	
	private Transferencia transferencia; 

	@Before
	public void iniciarSimulacaoTransferencia() {
		transferencia = new Transferencia();
		transferencia.setContaDestino("88057-5");
		transferencia.setContaOrigem("88057-4");
		transferencia.setDataCadastro(LocalDate.now());
		transferencia.setDataAgendamento(LocalDate.now().minusDays(30));
		transferencia.setTipo(TipoTransferencia.D);
	}
	
	@Test
	public void calcularValorTaxaTipoDMaiorQueCentoVinteMil () {
		transferencia.setValor(new BigDecimal("130000"));
		transferencia.setTaxa(CalculadorTaxaService.getInstance(transferencia).getValorTaxa());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal("2730")) == 0);
	}
	
	@Test
	public void calcularValorTaxaTipoDMaiorQueCentoVinteMilParaAgendamentosAteVinteCincoDias () {
		transferencia.setValor(new BigDecimal("130000"));
		transferencia.setDataAgendamento(LocalDate.now().minusDays(25));
		transferencia.setTaxa(CalculadorTaxaService.getInstance(transferencia)
				.getValorTaxa());
			
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal("5590")) == 0);
	}
	
	@Test
	public void calcularValorTaxaTipoDMaiorQueCentoVinteMilParaAgendamentosAteVinteDias () {
		transferencia.setValor(new BigDecimal("130000"));
		transferencia.setDataAgendamento(LocalDate.now().minusDays(20));
		transferencia.setTaxa(CalculadorTaxaService.getInstance(transferencia)
				.getValorTaxa());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal("7020")) == 0);
	}
	
	@Test
	public void calcularValorTaxaTipoDMaiorQueCentoVinteMilParaAgendamentosAteQuinzeDias () {
		transferencia.setValor(new BigDecimal("130000"));
		transferencia.setDataAgendamento(LocalDate.now().minusDays(15));
		transferencia.setTaxa(CalculadorTaxaService.getInstance(transferencia)
				.getValorTaxa());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal("8710")) == 0);
	}
	
	@Test
	public void calcularValorTaxaTipoDMaiorQueCentoVinteMilParaAgendamentosAteDezDias () {
		transferencia.setValor(new BigDecimal("130000"));
		transferencia.setDataAgendamento(LocalDate.now().minusDays(10));
		transferencia.setTaxa(CalculadorTaxaService.getInstance(transferencia)
				.getValorTaxa());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal("9620")) == 0);
	}
	
	@Test
	public void calcularValorTaxaTipoDMaiorQueCentoVinteMilParaAgendamentosAteCincoDias () {
		transferencia.setValor(new BigDecimal("130000"));
		transferencia.setDataAgendamento(LocalDate.now().minusDays(5));
		transferencia.setTaxa(CalculadorTaxaService.getInstance(transferencia)
				.getValorTaxa());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal("10790")) == 0);
	}
	
	public void calcularValorTaxaTipoDEntreVinteCincoMilEhCentoVinteMilMaiorTrintaDias() {
		transferencia.setValor(new BigDecimal("30000"));
		transferencia.setDataAgendamento(LocalDate.now().minusDays(50));
		transferencia.setTaxa(CalculadorTaxaService.getInstance(transferencia).getValorTaxa());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal("8")) == 0);
	}
	
	public void calcularValorTaxaTipoDEntreVinteCincoMilEhCentoVinteMil() {
		transferencia.setValor(new BigDecimal("30000"));
		transferencia.setTaxa(CalculadorTaxaService.getInstance(transferencia).getValorTaxa());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal("10")) == 0);
	}
	
	public void calcularValorTaxaTipoDAteVinteCincoMil() {
		transferencia.setValor(new BigDecimal("25000"));
		transferencia.setTaxa(CalculadorTaxaService.getInstance(transferencia).getValorTaxa());
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal("752")) == 0);
	}

}
