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
		System.out.println("--------------------------------");
		System.out.println("Final de teste de Endereço");
		System.out.println("--------------------------------");
	}

	@Test(expected = NullPointerException.class)
	public void logradouro_nao_pode_ser_nulo() {
		endereco.setLogradouro(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void logradouro_nao_pode_ter_caracteres_especiais() {
		endereco.setLogradouro("rua 123 !@#$");
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

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_Aceitar_numero_menor_que_0() {
		int n = (int) (-1 * (Math.random() * 2147483647));
		endereco.setNumero(n);
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_numero_vazio() {
		endereco.setNumero(null);
	}

	@Test
	public void deve_aceitar_numero_entre_0_e_2147483647() {
		int n = (int) (Math.random() * 2147483647);
		endereco.setNumero(n);
	}

	@Test
	public void deve_aceitar_numero_maximo_de_integer_2147483647() {
		endereco.setNumero(2147483647);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_o_numero_minimo_de_integer_pois_e_negativo() {
		endereco.setNumero(-2147483648);
	}

	@Test(expected = NullPointerException.class)
	public void cep_nao_pode_ser_nulo() {
		endereco.setCep(null);
	}

	@Test
	public void deve_aceitar_o_menor_cep_00000001() {
		endereco.setCep("00000001");
	}

	@Test
	public void deve_aceitar_o_maior_cep_99999999() {
		endereco.setCep("99999999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_pode_ser_menor_que_00000001_com_0_a_esquerda() {
		endereco.setCep("00000000");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_pode_conter_menos_que_8_digitos() {
		endereco.setCep("1234567");
	}

	@Test
	public void deve_aceitar_cep_com_0_a_esquerda_com_8_digitos_maior_que_o_01001000() {
		endereco.setCep("01234567");
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

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_cep_negativo_com_a_quantidade_de_digitos_certo() {
		endereco.setCep("-12345678");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_cep_negativo_com_a_quantidade_de_digitos_incorreta() {
		endereco.setCep("-1234567");
	}

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

	@Test(expected = NullPointerException.class)
	public void cidade_nao_pode_ser_nula() {
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

	@Test(expected = NullPointerException.class)
	public void tipo_nao_pode_ser_nula() {
		endereco.setTipo(null);
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

	@Test
	public void deve_aceitar_tostring_endereco_completo_e_correto() {
		Endereco endereco2 = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) "12345678",
				(String) "Perto do metro", (String) "Tauapé", (String) "São Paulo", (String) "São Paulo",
				(String) "Brasil", (String) "Filial");
		System.out.println(endereco2.toString());
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_tostring_endereco_com_tipo_nulo() {
		Endereco endereco2 = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) "12345678",
				(String) "Perto do metro", (String) "Tauapé", (String) "São Paulo", (String) "São Paulo",
				(String) "Brasil", (String) null);
		System.out.println(endereco2.toString());

	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_tostring_endereco_com_pais_nulo() {
		Endereco endereco2 = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) "12345678",
				(String) "Perto do metro", (String) "Tauapé", (String) "São Paulo", (String) "São Paulo", (String) null,
				(String) "Filial");
		System.out.println(endereco2.toString());

	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_tostring_endereco_com_estado_nulo() {
		Endereco endereco2 = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) "12345678",
				(String) "Perto do metro", (String) "Tauapé", (String) "São Paulo", (String) null, (String) "Brasil",
				(String) "Filial");
		System.out.println(endereco2.toString());

	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_tostring_endereco_com_cidade_nula() {
		Endereco endereco2 = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) "12345678",
				(String) "Perto do metro", (String) "Tauapé", (String) null, (String) "São Paulo", (String) "Brasil",
				(String) "Filial");
		System.out.println(endereco2.toString());

	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_tostring_endereco_com_bairro_nulo() {
		Endereco endereco2 = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) "12345678",
				(String) "Perto do metro", (String) null, (String) "São Paulo", (String) "São Paulo", (String) "Brasil",
				(String) "Filial");
		System.out.println(endereco2.toString());
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_tostring_endereco_com_complemento_nulo() {
		Endereco endereco2 = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) "12345678", (String) null,
				(String) "Tauapé", (String) "São Paulo", (String) "São Paulo", (String) "Brasil", (String) "Filial");
		System.out.println(endereco2.toString());
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_tostring_endereco_com_cep_nulo() {
		Endereco endereco2 = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) null, (String) "Perto do metro",
				(String) "Tauapé", (String) "São Paulo", (String) "São Paulo", (String) "Brasil", (String) "Filial");
		System.out.println(endereco2.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_tostring_endereco_com_numero_negativo() {
		Endereco endereco2 = new Endereco((String) "Rua Tatuapé", (int) -123, (String) "12345678",
				(String) "Perto do metro", (String) "Tauapé", (String) "São Paulo", (String) "São Paulo",
				(String) "Brasil", (String) "Filial");
		System.out.println(endereco2.toString());
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_tostring_endereco_com_logradouro_nulo() {
		Endereco endereco2 = new Endereco((String) null, (Integer) 0, (String) "12345678", (String) "Perto do metro",
				(String) "Tauapé", (String) "São Paulo", (String) "São Paulo", (String) "Brasil", (String) "Filial");
		System.out.println(endereco2.toString());
	}

	@Test
	public void deve_aceitar_enderecos_iguais_nao_vazios_com_o_mesmo_hashcode() {
		Endereco endereco = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) "12345678",
				(String) "Perto do metro", (String) "Tauapé", (String) "São Paulo", (String) "São Paulo",
				(String) "Brasil", (String) "Matriz");
		Endereco endereco2 = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) "12345678",
				(String) "Perto do metro", (String) "Tauapé", (String) "São Paulo", (String) "São Paulo",
				(String) "Brasil", (String) "Matriz");
		assertTrue(endereco.equals(endereco2) && endereco2.equals(endereco));
		assertTrue(endereco.hashCode() == endereco2.hashCode());
	}

	@Test
	public void nao_deve_aceitar_enderecos_completos_com_hashcodes_diferentes() {
		Endereco endereco = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) "12345678",
				(String) "Perto do metro", (String) "Tauapé", (String) "São Paulo", (String) "São Paulo",
				(String) "Brasil", (String) "Matriz");
		Endereco endereco2 = new Endereco((String) "Rua Tatuapé", (Integer) 0, (String) "12345678",
				(String) "Perto do metro", (String) "Tauapé", (String) "São Paulo", (String) "São Paulo",
				(String) "Brasil", (String) "Filial 1");
		assertTrue(endereco.hashCode() != endereco2.hashCode());
	}

}
