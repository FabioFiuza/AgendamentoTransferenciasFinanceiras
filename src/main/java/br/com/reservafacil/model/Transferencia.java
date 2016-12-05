package br.com.reservafacil.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.reservafacil.model.enumeration.TipoTransferencia;

public class Transferencia implements Serializable {

	private static final long serialVersionUID = -2468290111398686739L;
	
	private String contaOrigem; 
	private String contaDestino; 
	private BigDecimal valor; 
	private BigDecimal taxa; 
	private LocalDate dataAgendamento; 
	private TipoTransferencia tipo;
	private LocalDate dataCadastro; 
	
	public String getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public String getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getTaxa() {
		return taxa;
	}
	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public TipoTransferencia getTipo() {
		return tipo;
	}
	public void setTipo(TipoTransferencia tipo) {
		this.tipo = tipo;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
