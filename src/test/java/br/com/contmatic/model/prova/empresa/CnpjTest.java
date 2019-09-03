package br.com.contmatic.model.prova.empresa;

import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Empresa;

public class CnpjTest {

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
		System.out.println("Teste de CNPJ realizado");
	}
	
	@AfterClass
	public static void fim_dos_testes_de_cnpj() {
		System.out.println("-------------------------");
		System.out.println("Final de testes de CNPJ");
		System.out.println("--------------------------");
	}


	@Test
	public void deve_aceitar_o_cnpj_valido() {
		empresa.setCnpj(83280092000138l);
		assertTrue(empresa.isCNPJ(String.valueOf(empresa.getCnpj())));
	}

	@Test
	public void nao_aceitar_o_cnpj_invalido() {
		empresa.setCnpj(33280092000138l);
		assertFalse(empresa.isCNPJ(String.valueOf(empresa.getCnpj())));

	}

	@Test
	public void cnpj_14_digitos() {
		empresa.setCnpj(33280092000138l);
		assertThat(String.valueOf(empresa.getCnpj()).length(), is(14));

	}
	
	
}
