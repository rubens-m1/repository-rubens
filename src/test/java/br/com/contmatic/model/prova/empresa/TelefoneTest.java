package br.com.contmatic.model.prova.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Telefone;

public class TelefoneTest {

	private Telefone telefone;

	@Before

	public void init() {
		telefone = new Telefone();
		System.out.println("");
	}

	@Ignore
	@Test
	public void este_teste_sera_ignorado() {
	}
	
	@After
	public void finish() {
		System.out.println("Teste de telefone realizado");
	}
	
	@AfterClass
	public static void fim_dos_testes_de_cnpj() {
		System.out.println("-------------------------");
		System.out.println("Final de testes de Telefone");
		System.out.println("--------------------------");
	}



	// DDD TESTES
	@Test(expected = IllegalArgumentException.class)
	public void validacao_de_ddd_entre_11_e_99() {
		telefone.setDdd((byte) 20);

	}

	@Test(expected = IllegalArgumentException.class)
	public void ddd_nao_pode_ser_abaixo_de_11() {
		telefone.setDdd((byte) -2);

	}

	@Test(expected = IllegalArgumentException.class)
	public void ddd_nao_pode_ser_acima_de_99() {
		telefone.setDdd((byte) 101);
	}

	@Test
	public void ddd_comprimento_de_2_digitos() {
		telefone.setDdd((byte) 11);
		assertThat(String.valueOf(telefone.getDdd()).length(), is(2));
	}

	// NUMERO TESTES
	@Test(expected = IllegalArgumentException.class)
	public void numero_nao_pode_de_menos_de_8_digitos() {
		telefone.setNumero(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void numero_nao_pode_de_menos_de_8_digitos_incluindo_os_0() {
		telefone.setNumero(01234567);
	}

	@Test(expected = IllegalArgumentException.class)
	public void numero_nao_pode_ter_mais_de_9_digitos() {
		telefone.setNumero(1000000000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void numero_nao_pode_ter_mais_de_9_digitos_incluindo_os_0() {
		telefone.setNumero(010000000);
	}

	@Test
	public void deve_aceitar_numero_com_oito_digitos() {
		telefone.setNumero(12345678);
		assertThat(String.valueOf(telefone.getNumero()).length(), is(8));
	}

	@Test
	public void deve_aceitar_numero_com_nove_digitos() {
		telefone.setNumero(987654321);
		assertThat(String.valueOf(telefone.getNumero()).length(), is(9));
	}

	// RAMAL TESTES
	@Test
	public void ramal_pode_ser_nulo() {
		telefone.setComplemento(null);
		assertTrue(telefone.getRamal() == null);
	}

	@Test
	public void deve_acietar_ramal_0() {
		telefone.setRamal("0");
		assertTrue(telefone.getRamal().equals("0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ramal_maior_que_99999999() {
		telefone.setRamal("1000000000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ramal_menor_que_0() {
		telefone.setRamal("-11");
	}

	// COMPLEMENTO TESTES
	@Test
	public void complemento_pode_ser_nulo() {
		telefone.setComplemento(null);
		assertTrue(telefone.getComplemento() == null);
	}

	public void complemento_pode_ser_qualqier_coisa() {
		telefone.setComplemento("Perto do mercado");
		assertTrue(telefone.getComplemento().equals("Perto do mercado"));
	}

	@Test
	public void complemento_pode_aceitar_caracteres_especiais() {
		telefone.setComplemento("@#$%Â¨&*");
		assertTrue(telefone.getComplemento().equals("@#$%Â¨&*"));
	}

}
