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
		System.out.println("------------------------------");
		System.out.println("Final de testes de Telefone");
		System.out.println("------------------------------");
	}

	// DDD TESTES

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_ddd_nulo() {
		telefone.setDdd((Byte) null);
	}

	@Test
	public void deve_aceitar_ddd_entre_11_e_99_valido() {
		telefone.setDdd((byte) 11);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ddd_entre_11_e_99_invalido() {
		telefone.setDdd((byte) 20);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_pode_aceitar_ddd_abaixo_de_0() {
		int n = (int) (-1 * (Math.random() * 127));
		telefone.setDdd((byte) n);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_pode_aceitar_ddd_entre_0_e_10() {
		int n = (int) (Math.random() * 11);
		telefone.setDdd((byte) n);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_pode_Aceitar_ddd_() {
		int n = (int) ((Math.random() * 28) + 100);
		telefone.setDdd((byte) n);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_Aceitar_ddd_minimo_menos_128() {
		telefone.setDdd((byte) -128);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ddd_maximo_127() {
		telefone.setDdd((byte) 127);
	}

	@Test
	public void ddd_comprimento_de_2_digitos() {
		telefone.setDdd((byte) 11);
		assertThat(String.valueOf(telefone.getDdd()).length(), is(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ddd_comprimento_de_1_digito() {
		telefone.setDdd((byte) 1);
		assertThat(String.valueOf(telefone.getDdd()).length(), is(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ddd_comprimento_de_3_digitos() {
		telefone.setDdd((byte) 111);
		assertThat(String.valueOf(telefone.getDdd()).length(), is(3));
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_numero_nulo() {
		telefone.setNumero(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void numero_nao_pode_de_menos_de_8_digitos() {
		telefone.setNumero(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void numero_nao_pode_de_menos_de_8_digitos_randomico() {
		int n = (int) (Math.random() * 9999999);
		telefone.setNumero(n);
	}

	@Test(expected = IllegalArgumentException.class)
	public void numero_nao_pode_ter_menos_de_8_digitos_incluindo_os_0() {
		telefone.setNumero(01234567);
	}

	@Test
	public void deve_aceitar_valor_minimo_de_8_digitos() {
		telefone.setNumero(10000000);
	}

	@Test
	public void de_aceitar_valor_maximo_de_8_digitos() {
		telefone.setNumero(99999999);
	}

	@Test(expected = IllegalArgumentException.class)
	public void numero_nao_pode_ter_mais_de_9_digitos() {
		telefone.setNumero(1000000000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_pode_aceitar_numero_com_mais_de_9_digitos_randomico() {
		int n = (int) ((Math.random() * 1147483646) + 1000000000);
		telefone.setNumero(n);
	}

	@Test(expected = IllegalArgumentException.class)
	public void numero_nao_pode_ter_mais_de_9_digitos_incluindo_os_0() {
		telefone.setNumero(010000000);
	}

	@Test
	public void deve_aceitar_numero_com_oito_digitos() {
		int n = (int) (((Math.random() * 89999999) + 10000000));
		telefone.setNumero(n);
		assertThat(String.valueOf(telefone.getNumero()).length(), is(8));
	}

	@Test
	public void deve_aceitar_numero_com_nove_digitos_randomico() {
		int n = (int) (((Math.random() * 899999999) + 100000000));
		telefone.setNumero(n);
		assertThat(String.valueOf(telefone.getNumero()).length(), is(9));
	}

	@Test
	public void deve_aceitar_numero_com_nove_digitos() {
		telefone.setNumero(987654321);
		assertThat(String.valueOf(telefone.getNumero()).length(), is(9));
	}

	@Test
	public void deve_aceitar_numero_minimo_com_9_digitos() {
		telefone.setNumero(100000000);
	}

	@Test
	public void deve_aceitar_numero_maximo_com_9_digitos() {
		telefone.setNumero(999999999);
	}

	@Test
	public void deve_aceitar_ramal_pode_ser_nulo() {
		telefone.setComplemento(null);
		assertTrue(telefone.getRamal() == null);
	}

	@Test
	public void deve_aceitar_ramal_0() {
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

	@Test
	public void deve_aceitar_complemento_nulo() {
		telefone.setComplemento(null);
		assertTrue(telefone.getComplemento() == null);
	}

	public void deve_aceitar_complemento_apenas_com_letras_e_espacos() {
		telefone.setComplemento("Perto do mercado");
		assertTrue(telefone.getComplemento().equals("Perto do mercado"));
	}

	public void deve_aceitar_complemento_com_letras_espacos_e_numeros() {
		telefone.setComplemento("Perto do mercado 123");
		assertTrue(telefone.getComplemento().equals("Perto do mercado 123"));
	}

	public void deve_aceitar_complemento_com_letras_espacos_numeros_e_caracteres_especiais() {
		telefone.setComplemento("Perto do mercado 123 !@#$");
		assertTrue(telefone.getComplemento().equals("Perto do mercado 123 !@#$"));
	}

	public void deve_aceitar_complemento_apenas_com_numeros() {
		telefone.setComplemento("123");
		assertTrue(telefone.getComplemento().equals("123"));
	}

	@Test
	public void complemento_pode_aceitar_caracteres_especiais() {
		telefone.setComplemento("@#$%Â¨&*");
		assertTrue(telefone.getComplemento().equals("@#$%Â¨&*"));
	}
	
	@Test
	public void deve_aceitar_to_string_de_numero_completo() {
		Telefone telefone = new Telefone((byte) 11, (Integer) 12345678,(String) null,(String) null);
		System.out.println(telefone.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_tostrig_com_ddd_invalido_e_numero_valido() {
		Telefone telefone = new Telefone((byte) 0, (Integer) 12345678,(String) null,(String) null);
		System.out.println(telefone.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_tostrig_com_ddd_valido_e_numero_invalido() {
		Telefone telefone = new Telefone((byte) 11, (Integer) 1234567,(String) "1",(String) null);
		System.out.println(telefone.toString());
	}

	@Test
	public void deve_aceitar_tostrig_ddd_mais_numero_mais_ramal_mais_complemento() {
		Telefone telefone = new Telefone((byte) 11, (Integer) 12345678,(String) "1",(String) "Diretoria");
		System.out.println(telefone.toString());
	}

	@Test
	public void deve_aceitar_telefones_vazios_com_o_mesmo_hash_code() {
		Telefone telefone1 = new Telefone();
		Telefone telefone2 = new Telefone();
		assertTrue(telefone1.equals(telefone2) && telefone2.equals(telefone1));
		assertTrue(telefone1.hashCode() == telefone2.hashCode());
	}

	@Test
	public void deve_aceitar_telefones_nao_vazios_com_o_mesmo_hash_code() {
		Telefone telefone1 = new Telefone((byte) 11, (Integer) 12345678,(String) "1",(String) "Diretoria");
		Telefone telefone2 = new Telefone((byte) 11, (Integer) 12345678,(String) "1",(String) "Diretoria");
		assertTrue(telefone1.equals(telefone2) && telefone2.equals(telefone1));
		assertTrue(telefone1.hashCode() == telefone2.hashCode());
	}

	@Test
	public void nao_deve_aceitar_telefones_nao_vazios_com_hashcode_diferentes() {
		Telefone telefone1 = new Telefone((byte) 11, (Integer) 12345678,(String) "1",(String) "Diretoria");
		Telefone telefone2 = new Telefone((byte) 11, (Integer) 12345678,(String) "2",(String) "Financeiro");
		assertTrue(telefone1.hashCode() != telefone2.hashCode());
	}
}
