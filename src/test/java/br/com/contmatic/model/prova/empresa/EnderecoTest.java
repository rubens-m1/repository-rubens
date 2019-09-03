package br.com.contmatic.model.prova.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Endereco;

public class EnderecoTest {

	private Endereco endereco;

	@Before
	public void init() {
		endereco = new Endereco();
		System.out.println("");
	}

	@Ignore
	@Test
	public void este_teste_sera_ignorado() {
	}
	
	@After
	public void finish() {
		System.out.println("Teste de endereço realizado");
	}
	
	@AfterClass
	public static void fim_dos_testes_de_cnpj() {
		System.out.println("-------------------------");
		System.out.println("Final de teste de Endereço");
		System.out.println("--------------------------");
	}


	// TESTES LOGRADOURO
	@Test(expected = NullPointerException.class)
	public void logradouro_nao_pode_ser_nulo() {
		endereco.setLogradouro(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void logradouro_nao_pode_ter_caracteres_especiais() {
		endereco.setLogradouro("rua  123 !@#$");

	}

	@Test(expected = IllegalArgumentException.class)
	public void logradouro_nao_pode_ter_caracteres_especiais_com_numeros() {
		endereco.setLogradouro("!@#123");

	}

	@Test
	public void logradouro_com_numero_dentro() {
		endereco.setLogradouro("Rua Sei la 123");
		assertTrue(endereco.getLogradouro().equals("Rua Sei la 123"));
	}

	@Test
	public void logradouro_pode_ter_acentos() {
		endereco.setLogradouro("Rua São José");
		assertTrue(endereco.getLogradouro().equals("Rua São José"));
	}

	// TESTES DE NUMERO DE LOGRADOURO
	@Test(expected = IllegalArgumentException.class)
	public void numero_nao_pode_ser_menor_que_0() {
		endereco.setNumero(-22);

	}

	// TESTES DE CEP
	@Test(expected = NullPointerException.class)
	public void cep_nao_pode_ser_nulo() {
		endereco.setCep(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_pode_ser_menor_que_00000001() {
		endereco.setCep("-00000001");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_pode_conter_menos_que_8_digitos() {
		endereco.setCep("1234567");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_pode_ter_mais_que_8_digitos() {
		endereco.setCep("123456789");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_pode_aceitar_numero_com_mais_de_oito_digitos_mesmo_com_zeros_na_frente() {
		endereco.setCep("012345678");
	}

	@Test
	public void cep_deve_ter_8_digitos() {
		endereco.setCep("12345678");
		assertThat(String.valueOf(endereco.getCep()).length(), is(8));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_pode_conter_letra() {
		endereco.setCep("a1234567");

	}

	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_pode_conter_so_letras() {
		endereco.setCep("abcdefgh");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_pode_conter_caractere_especial_caso_com_7_numeros_e_8_caracteres() {
		endereco.setCep("#1234567");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_pode_conter_caractere_especial_caso_com_8_numeros_e_9_caracteres() {
		endereco.setCep("#12345678");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_pode_conter_caracteres_especiais() {
		endereco.setCep("!@#$%Â¨&*");
	}

	// TESTES DE COMPLEMENTO
	@Test
	public void complemento_pode_ser_nulo() {
		endereco.setComplemento(null);
		assertTrue(endereco.getComplemento() == null);
	}

	@Test
	public void complemento_pode_conter_caracteres_especiais() {
		endereco.setComplemento("!@#$%Â¨&*");
		assertTrue(endereco.getComplemento().equals("!@#$%Â¨&*"));
	}

	@Test
	public void complemento_pode_ter_acentos() {
		endereco.setComplemento("São Judas");
		assertTrue(endereco.getComplemento().equals("São Judas"));
	}

	// TESTES DE BAIRRO
	@Test(expected = NullPointerException.class)
	public void bairro__nao_pode_ser_nulo() {
		endereco.setBairro(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void bairro_nao_pode_conter_caracteres_especiais() {
		endereco.setBairro("!@#$%Â¨&*");
	}

	@Test(expected = IllegalArgumentException.class)
	public void bairro_nao_pode_conter_caracteres_especiais_com_letras() {
		endereco.setBairro("São Judas !@#$%Â¨&*");
	}

	@Test(expected = IllegalArgumentException.class)
	public void bairro_nao_pode_conter_caracteres_especiais_com_numeros() {
		endereco.setBairro("1234 !@#$%Â¨&*");
	}

	@Test(expected = IllegalArgumentException.class)
	public void bairro_nao_pode_conter_caracteres_especiais_com_letras_e_numeros() {
		endereco.setBairro("bairro 123 !@#$%Â¨&*");
	}

	@Test
	public void bairro_pode_ter_acentos() {
		endereco.setBairro("São Judas");
		assertTrue(endereco.getBairro().equals("São Judas"));
	}

	// TESTES DE CIDADE
	@Test(expected = NullPointerException.class)
	public void cidade__nao_pode_ser_nula() {
		endereco.setCidade(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cidade_nao_pode_conter_letras_e_numero() {
		endereco.setCidade("São Paulo 123");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cidade_nao_pode_conter_caracteres_especiais() {
		endereco.setCidade("!@#$%Â¨&*");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cidade_nao_pode_conter_caracteres_especiais_com_letras() {
		endereco.setCidade("São Paulo !@#$");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cidade_nao_pode_conter_caracteres_especiais_com_numeros() {
		endereco.setCidade("1234 !@#$%Â¨&*");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cidade_nao_pode_conter_caracteres_especiais_com_letras_e_numeros() {
		endereco.setCidade("São Paulo 123 !@#$%");
	}

	@Test
	public void cidade_pode_ter_acentos() {
		endereco.setCidade("São Paulo");
		assertTrue(endereco.getCidade().equals("São Paulo"));
	}

	// TESTES DE ESTADO
	@Test(expected = NullPointerException.class)
	public void estado__nao_pode_ser_nulo() {
		endereco.setEstado(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void estado_nao_pode_conter_letras_e_numeros() {
		endereco.setEstado("Rio de Janeiro 123");
	}

	@Test(expected = IllegalArgumentException.class)
	public void estado_nao_pode_conter_caracteres_especiais() {
		endereco.setEstado("!@#$%Â¨&*");
	}

	@Test(expected = IllegalArgumentException.class)
	public void estado_nao_pode_conter_caracteres_especiais_com_letras() {
		endereco.setEstado("São Paulo !@#$");
	}

	@Test(expected = IllegalArgumentException.class)
	public void estado_nao_pode_conter_caracteres_especiais_com_numeros() {
		endereco.setEstado("1234 !@#$%Â¨&*");
	}

	@Test(expected = IllegalArgumentException.class)
	public void estado_nao_pode_conter_caracteres_especiais_com_letras_e_numeros() {
		endereco.setEstado("São Paulo 123 !#$%%");
	}

	@Test
	public void estado_pode_ter_acentos() {
		endereco.setEstado("São Paulo");
		assertTrue(endereco.getEstado().equals("São Paulo"));
	}

	// TESTES DE PAIS
	@Test(expected = NullPointerException.class)
	public void pais_nao_pode_ser_nulo() {
		endereco.setPais(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void pais_nao_pode_conter_letras_e_numeros() {
		endereco.setPais("Brasil 123");
	}

	@Test(expected = IllegalArgumentException.class)
	public void pais_nao_pode_conter_caracteres_especiais() {
		endereco.setPais("!@#$%Â¨&*");
	}

	@Test(expected = IllegalArgumentException.class)
	public void pais_nao_pode_conter_caracteres_especiais_com_letras() {
		endereco.setPais("Brasil !@#$");
	}

	@Test(expected = IllegalArgumentException.class)
	public void pais_nao_pode_conter_caracteres_especiais_com_numeros() {
		endereco.setPais("1234 !@#$%Â¨&*");
	}

	@Test(expected = IllegalArgumentException.class)
	public void pais_nao_pode_conter_caracteres_especiais_com_letras_e_numeros() {
		endereco.setPais("Brasil 123 !#$%%");
	}

	@Test
	public void pais_pode_ter_acentos() {
		endereco.setPais("São Tomé e Príncipe");
		assertTrue(endereco.getPais().equals("São Tomé e Príncipe"));
	}

	// TESTES DE TIPO
	@Test(expected = NullPointerException.class)
	public void matriz__nao_pode_ser_nula() {
		endereco.setBairro(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void tipo_nao_pode_conter_caracteres_especiais() {
		endereco.setTipo("!@#$%Â¨&*");
	}

	@Test(expected = IllegalArgumentException.class)
	public void tipo_nao_pode_conter_caracteres_especiais_com_letras() {
		endereco.setTipo("Matriz !@#$");
	}

	@Test(expected = IllegalArgumentException.class)
	public void tipo_nao_pode_conter_caracteres_especiais_com_numeros() {
		endereco.setTipo("1234 !@#$%Â¨&*");
	}

	@Test(expected = IllegalArgumentException.class)
	public void tipo_nao_pode_conter_caracteres_especiais_com_letras_e_numeros() {
		endereco.setPais("Filial 123 !#$%%");
	}

	@Test
	public void tipo_pode_ter_acentos() {
		endereco.setTipo("Filial de São Tomé e Príncipe");
		assertTrue(endereco.getTipo().equals("Filial de São Tomé e Príncipe"));
	}

	@Test
	public void tipo_pode_ter_numeros() {
		endereco.setTipo("Filial 12");
		assertTrue(endereco.getTipo().equals("Filial 12"));
	}

}