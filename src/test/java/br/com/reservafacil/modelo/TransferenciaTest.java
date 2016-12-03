package br.com.reservafacil.modelo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

public class TransferenciaTest {

	@Test
	public void calcularValorTransferenciaTipoA() {
		Transferencia transferencia = new Transferencia();
		
		transferencia.setContaDestino("88057-5");
		transferencia.setContaOrigem("88057-4");
		transferencia.setValor(new BigDecimal("150"));
		transferencia.setDataAgendamento(LocalDate.parse("2016-11-20"));
		transferencia.setTipo(TipoTransferencia.A);
		transferencia.setDataCadastro(LocalDate.now());
		transferencia.setTaxa(CalculadorTaxa.getInstance(TipoTransferencia.A, transferencia.getValor()).valorCalculado()); 
		
		assertTrue(transferencia.getTaxa().compareTo(new BigDecimal(6.5)) == 0);
	}

}
