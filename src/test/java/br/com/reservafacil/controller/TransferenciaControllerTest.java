package br.com.reservafacil.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockSerializationResult;
import br.com.reservafacil.model.Transferencia;
import br.com.reservafacil.model.enumeration.TipoTransferencia;

public class TransferenciaControllerTest {
	
	private static final String RETORNO_JSON_TRANSFERENCIA = "{\"transferencia\":{\"valor\":150,\"taxa\":6.50,\"tipo\":\"A\"}}";
	private static final String RETORNO_JSON_LISTA_TRANSFERENCIA = "{\"transferencias\":[{\"valor\":150,\"taxa\":6.50,\"dataAgendamento\":{\"year\":2016,\"month\":11,\"day\":5},\"tipo\":\"A\",\"dataCadastro\":{\"year\":2016,\"month\":12,\"day\":5}}]}";
	
	private MockSerializationResult result;
    private TransferenciaController controller;
    private Transferencia transferencia; 
	
    @Before
    public void setUp() {
        result = new MockSerializationResult();
        controller = new TransferenciaController(result);
		transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal("150"));
		transferencia.setDataAgendamento(LocalDate.now().minusDays(30));
		transferencia.setTipo(TipoTransferencia.A); 
    }

    @Test
	public void deveRetornarTransferenciaConvertidaJson() throws Exception {
		controller.agendarTransferenciaT(transferencia);
		assertEquals(RETORNO_JSON_TRANSFERENCIA, result.serializedResult());
    }
    
    @Test
    public void deveRetornarListaTransferenciaConvertidaJson() throws Exception {
    	controller.listarTrasnferencia();
		assertEquals(RETORNO_JSON_LISTA_TRANSFERENCIA, result.serializedResult());
    }
	
}
