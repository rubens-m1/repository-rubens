package br.com.contmatic.model.prova.empresa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Empresa;
import br.com.contmatic.prova.empresa.Endereco;
import br.com.contmatic.prova.empresa.Telefone;

public class EmpresaTest {

	private Empresa empresa;

	private Endereco[] enderecos;

	private Endereco endereco;

	private Telefone[] telefones;

	private Telefone telefone;

	@Before
	public void init() {
		endereco = new Endereco();
		enderecos = new Endereco[1];
		enderecos[0] = endereco;

		endereco.setLogradouro("Rua tatuapé");
		endereco.setNumero(0);
		endereco.setCep("12345678");
		endereco.setComplemento("Perto do metro");
		endereco.setBairro("Tatuapé");
		endereco.setCidade("São Paulo");
		endereco.setEstado("São Paulo");
		endereco.setPais("Brasil");
		endereco.setTipo("Matriz");
		enderecos[0] = endereco;

		telefone = new Telefone();
		telefones = new Telefone[1];
		telefones[0] = telefone;

		telefone.setDdd((byte) 11);
		telefone.setNumero(123456789);
		telefone.setRamal("1");
		telefone.setComplemento("Diretoria");
		telefones[0] = telefone;

		empresa = new Empresa("nome fantasia", "razao social", "83280092000138", enderecos, telefones, "rubens@123.com",
				"www.rubens.com.br");
		System.out.println("");
	}

	@After
	public void finish() {
		System.out.println("Teste de empresa realizado");
	}
	
	@AfterClass
	public static void fim_dos_testes_de_cnpj() {
		System.out.println("------------------------------");
		System.out.println("Final de testes de Empresa");
		System.out.println("------------------------------");
	}

	@Test
	public void deve_aceitar_empresa_com_todos_os_campos_prechidos_e_corretos() {
		System.out.println(empresa.toString());
	}

	@Test
	public void deve_aceitar_empresa_com_nome_fantasia_nulo() {
		empresa.setNomeFantasia(null);
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_empresa_com_razao_social_nulo() {
		empresa.setRazaoSocial(null);
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_empresa_com_cnpj_nulo() {
		empresa.setCnpj(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_empresa_com_cnpj_invalido() {
		empresa.setCnpj("123456");
		System.out.println(empresa.toString());
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_empresa_com_enderecos_nulos() {
		empresa.setEnderecos(null);
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_empresa_com_telefones_nulos() {
		empresa.setTelefones(null);
	}

	@Test(expected = NullPointerException.class)
	public void nao_deve_aceitar_empresa_email_nulo() {
		empresa.setEmail(null);
	}

	@Test
	public void deve_aceitar_empresa_com_site_nulo() {
		empresa.setSite(null);
		System.out.println(empresa.toString());
	}

	@Test
	public void deve_aceitar_empresa_com_nome_fantasia_e_site_nulos() {
		empresa.setNomeFantasia(null);
		empresa.setSite(null);
	}
}
