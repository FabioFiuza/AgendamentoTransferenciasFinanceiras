package br.com.reservafacil.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

@Controller
public class TransferenciaController {

	private final Result result;
	
	protected TransferenciaController() {
		this(null);
	}
	
	@Inject
	public TransferenciaController(Result result) {
		this.result = result;
	}
	
	
}
