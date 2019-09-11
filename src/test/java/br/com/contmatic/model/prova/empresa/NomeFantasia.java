package br.com.contmatic.model.prova.empresa;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Empresa;

public class NomeFantasia {

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
		System.out.println("Teste de nome fantasia realizado");
	}

	@AfterClass
	public static void fim_dos_testes_de_cnpj() {
		System.out.println("---------------------------------");
		System.out.println("Final de testes de Nome Fantasia");
		System.out.println("---------------------------------");
	}

	@Test
	public void deve_aceitar_nome_fantasia_valido_com_letras() {
		empresa.setNomeFantasia("Nome Fantasia Rubens");
	}

	@Test
	public void deve_aceitar_nome_fantasia_valido_com_numeros() {
		empresa.setNomeFantasia("123 4 5000");
	}

	@Test
	public void deve_aceitar_nome_fantasia_com_letras_e_numeros() {
		empresa.setNomeFantasia("Nome Fantasia Rubens 123");
	}

	@Test
	public void nome_fantasia_pode_ser_nulo() {
		empresa.setNomeFantasia(null);
		assertTrue(empresa.getNomeFantasia() == null);
	}

	@Test
	public void nome_fantasia_pode_ter_caracteres_especiais_numeros_e_letras() {
		empresa.setNomeFantasia("!@#%Â¨SFFxsd {^^{}dsdsbd");
		assertTrue(empresa.getNomeFantasia().equals("!@#%Â¨SFFxsd {^^{}dsdsbd"));
	}

}
