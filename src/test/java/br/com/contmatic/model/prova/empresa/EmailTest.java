package br.com.contmatic.model.prova.empresa;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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
	public void deve_aceitar_email_valido() {
		empresa.setEmail("rubens@contmatic.com.br");
		assertTrue(empresa.getEmail().equals("rubens@contmatic.com.br"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_email_invalido_sem_arroba() {
		empresa.setEmail("rubens.123.com.br");
		
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_email_invalido_com_espaco() {
		empresa.setEmail("rubens @123.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_email_invalido_com_espaco_e_sem_arroba() {
		empresa.setEmail("rubens .123.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_email_invalido_com_espaco_e_com_mais_de_um_arroba() {
		empresa.setEmail("rubens @@123.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_email_com_mais_de_um_arroba() {
		empresa.setEmail("aa@@.com.br");
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_email_nulo() {
		empresa.setEmail(null);
	}
	
}
