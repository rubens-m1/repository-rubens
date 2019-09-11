package br.com.contmatic.model.prova.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.prova.empresa.Empresa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

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
		System.out.println("--------------------------");
		System.out.println("Final de testes de CNPJ");
		System.out.println("--------------------------");
	}

	@Test
	public void deve_aceitar_o_cnpj_valido() {
		empresa.setCnpj("83280092000138");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_o_cnpj_0() {
		empresa.setCnpj("00000000000000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_o_cnpj_1() {
		empresa.setCnpj("11111111111111");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_o_cnpj_2() {
		empresa.setCnpj("22222222222222");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_o_cnpj_3() {
		empresa.setCnpj("33333333333333");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_o_cnpj_4() {
		empresa.setCnpj("44444444444444");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_o_cnpj_5() {
		empresa.setCnpj("55555555555555");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_o_cnpj_6() {
		empresa.setCnpj("66666666666666");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_o_cnpj_7() {
		empresa.setCnpj("77777777777777");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_o_cnpj_8() {
		empresa.setCnpj("88888888888888");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_o_cnpj_9() {
		empresa.setCnpj("99999999999999");
	}

	@Test
	public void deve_aceitar_o_cnpj_valido_comecado_com_0() {
		empresa.setCnpj("03178590000135");
	}

	@Test(timeout = 10)
	public void deve_aceitar_cnpj_com_14_digitos_valido() {
		empresa.setCnpj("83280092000138");
		assertThat(String.valueOf(empresa.getCnpj()).length(), is(14));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_aceitar_o_cnpj_invalido_com_14_digitos() {
		empresa.setCnpj("12380092000138");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_cnpj_com_13_digitos() {
		empresa.setCnpj("3280092000138");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_aceitar_cnpj_com_menos_de_14_digitos() {
		empresa.setCnpj("8");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_cnpj_com_mais_de_14_digitos() {
		empresa.setCnpj("123280092000138");
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_cnpj_nulo() {
		empresa.setCnpj(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_valor_maximo_do_long() {
		empresa.setCnpj("9223372036854775807");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_valor_minimo_do_long() {
		empresa.setCnpj("-9223372036854775808");
	}
}
