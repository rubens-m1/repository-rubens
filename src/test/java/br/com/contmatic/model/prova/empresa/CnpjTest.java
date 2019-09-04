package br.com.contmatic.model.prova.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import  org.junit.FixMethodOrder ;
import org.junit.Ignore;
import org.junit.Test;
import  org.junit.runners.MethodSorters ;

import br.com.contmatic.prova.empresa.Empresa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CnpjTest {

	private Empresa empresa;

	@Before
	public void init() {
		empresa = new Empresa();
		System.out.println("");
	}
	
//	public void init() {
//		empresa = new Empresa(0, null, null, null);
//		empresa.setCnpj(82304554000147l);
//		empresa.setEnderecos(null);
//		empresa.setRazaoSocial("Rubens");
//		empresa.setTelefones(null);
//		System.out.println("");
//	}


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

	@Test(timeout = 10)
	public void cnpj_14_digitos() {
		empresa.setCnpj(33280092000138l);
		assertThat(String.valueOf(empresa.getCnpj()).length(), is(14));

	}
	
	@Test
	public void nao_aceitar_cnpj_com_menos_de_14_digitos() {
	 empresa.setCnpj(3280092000138l);
	 assertThat(String.valueOf(empresa.getCnpj()).length(), is(13));
	}
	
	@Test
	public void identificar_cnpj_com_13_digitos() {
		empresa.setCnpj(3280092000138l);
		assertFalse(empresa.isCNPJ(String.valueOf(empresa.getCnpj())));
	}

	@Test
	public void identificar_cnpj_com_15_digitos() {
	 empresa.setCnpj(123280092000138l);
	 assertThat(String.valueOf(empresa.getCnpj()).length(), is(15));
	}
	
	@Test
	public void nao_deve_aceitar_cnpj_com_mais_de_14_digitos() {
		empresa.setCnpj(123280092000138l);
		assertFalse(empresa.isCNPJ(String.valueOf(empresa.getCnpj())));
	}
	
}
