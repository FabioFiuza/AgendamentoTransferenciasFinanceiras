package br.com.reservafacil.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.reservafacil.modelo.taxa.CalculadorTaxa;
import br.com.reservafacil.modelo.transferencia.Transferencia;

@Controller
public class TransferenciaController {

	private final Result result;
	private static List<Transferencia> simularBancoDandos; 
	
	protected TransferenciaController() {
		this(null);
	}
	
	@Inject
	public TransferenciaController(Result result) {
		this.result = result;
	}
	
	@Path("/")
	public void index() {
		//TODO - Abrir pagina inicial da aplicacao
	}
	
	@Post
	@Path("/agendar")
	public void agendarTransferenciaT(Transferencia transferencia) {
		if(isNaoContemErrosValidacao(transferencia)) {
			transferencia.setTaxa(CalculadorTaxa.getInstance(transferencia).valorCalculado());
			simularBancoDandos.add(transferencia);					
			
			result.include(transferencia); //TODO - Confirmar se a chamada e feita dessa forma
		}
	}
	
	@Get
	@Path("/listar")
	public void listarTrasnferencia() {
		if(simularBancoDandos != null) {
			result.include(simularBancoDandos);
		}
	}

	private boolean isNaoContemErrosValidacao(Transferencia transferencia) {
		return true;
	}
	
}
