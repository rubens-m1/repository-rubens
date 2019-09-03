package br.com.contmatic.model.prova.empresa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import br.com.contmatic.prova.empresa.Empresa;

public class RazaoSocialTest {
	
	private Empresa empresa;
	
	@Before
	public void init() {
		empresa = new Empresa();
		System.out.println("");
		
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_razao_social_nula() {
		empresa.setRazaoSocial(null);

	}

	@Ignore
	@Test
	public void este_teste_sera_ignorado() {
	}
	
	@After
	public void finish() {
		System.out.println("Teste de razao social realizado");
	}
	
	@AfterClass
	public static void fim_dos_testes_de_razao_social() {
		System.out.println("-------------------------");
		System.out.println("Final de testes de Razão Social");
		System.out.println("--------------------------");
	}



}
