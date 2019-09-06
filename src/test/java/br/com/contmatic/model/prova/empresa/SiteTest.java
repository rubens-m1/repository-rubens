package br.com.contmatic.model.prova.empresa;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Empresa;

public class SiteTest {

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
		System.out.println("Teste de site realizado");
	}
	
	@AfterClass
	public static void fim_dos_testes_de_cnpj() {
		System.out.println("-------------------------");
		System.out.println("Final de testes de Site");
		System.out.println("--------------------------");
	}



	@Test
	public void site_pode_ser_nulo() {
		empresa.setSite(null);
		assertTrue(empresa.getSite() == null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_pode_ter_espaco() {
		empresa.setSite(" ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_pode_ter_espacos_no_site() {
		empresa.setSite("rubes .com.br");
	}

	@Test
	public void site_pode_ter_qualquer_caractere_que_nao_for_espaco() {
		empresa.setSite("!@#$^{SXSC^`S{CXAcsvcsxbb");
		assertTrue(empresa.getSite().equals("!@#$^{SXSC^`S{CXAcsvcsxbb"));
	}

	@Test
	public void site_rubens_valido() {
		empresa.setSite("www.rubens.com.br");
		assertTrue(empresa.getSite().contentEquals("www.rubens.com.br"));
	}

}
