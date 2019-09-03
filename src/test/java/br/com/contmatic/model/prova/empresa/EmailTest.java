package br.com.contmatic.model.prova.empresa;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
//import org.junit.jupiter.api.Order;

import br.com.contmatic.prova.empresa.Empresa;

public class EmailTest {

	private Empresa empresa;

	@Before
	public void init() {
		empresa = new Empresa();
		System.out.println("");
	}

	@Ignore
	@Test
	public void este_teste_sera_ignorado() {
	}
	
	@After
	public void finish() {
		System.out.println("Teste de email realizado");
	}
	
	@AfterClass
	public static void fim() {
		System.out.println("-------------------------");
		System.out.println("Final de testes do Email");
		System.out.println("--------------------------");
	}


	@Test
	public void email_valido() {
		empresa.setEmail("rubens@contmatic.com.br");
		assertTrue(empresa.getEmail().equals("rubens@contmatic.com.br"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void email_nao_pode_ter_espacos() {
		empresa.setEmail("rubens @123.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void email_nao_pode_ter_mais_de_um_arroba() {
		empresa.setEmail("aa@@");
	}

	@Test(expected = NullPointerException.class)
	public void email_nao_pode_ser_nulo() {
		empresa.setEmail(null);
	}
}
