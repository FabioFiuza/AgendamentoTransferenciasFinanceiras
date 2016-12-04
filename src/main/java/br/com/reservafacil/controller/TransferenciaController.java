package br.com.reservafacil.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.reservafacil.modelo.taxa.CalculadorTaxa;
import br.com.reservafacil.modelo.transferencia.Transferencia;

@Controller
public class TransferenciaController {

	private final Result result;
	private static List<Transferencia> transferencias = new ArrayList<>();
	
	protected TransferenciaController() {
		this(null);
	}
	
	@Inject
	public TransferenciaController(Result result) {
		this.result = result;
	}
	
	@Path("/")
	public void index() {
	}
	
	@Post
	@Path("/agendar")
	@Consumes("application/json")
	public void agendarTransferenciaT(Transferencia transferencia) {
		if(isNaoContemErrosValidacao(transferencia)) {
			transferencia.setDataCadastro(LocalDate.now());
			transferencia.setTaxa(CalculadorTaxa.getInstance(transferencia).valorCalculado());
			transferencias.add(transferencia);
			result.use(Results.json()).from(transferencia, "transferencia").serialize();
		}
	}
	
	@Get
	@Path("/listar")
	public void listarTrasnferencia() {
		if(transferencias != null) {
			result.use(Results.json()).from(transferencias, "transferencias").include("dataAgendamento", "dataCadastro") .serialize();
		}
	}

	private boolean isNaoContemErrosValidacao(Transferencia transferencia) {
		return true;
	}
	
}
