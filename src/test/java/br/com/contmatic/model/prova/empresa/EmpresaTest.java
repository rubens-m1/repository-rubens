package br.com.contmatic.model.prova.empresa;

import org.junit.After;
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

		telefone = new Telefone();
		telefones = new Telefone[1];
		telefones[0] = telefone;
		empresa = new Empresa(83280092000138l, "Rubens", enderecos, telefones, "rubens@123.com");
		System.out.println("");
	}

	@After
	public void finish() {
		System.out.println("Teste de empresa realizado");
	}

//	toString Testes
	@Test
	public void deve_aceitar_empresa_com_todos_os_campos_prechidos_e_corretos() {

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

		telefone.setDdd((byte) 11);
		telefone.setNumero(123456789);
		telefone.setRamal("1");
		telefone.setComplemento("Diretoria");
		telefones[0] = telefone;

		empresa.setNomeFantasia("Rubens");
		empresa.setEnderecos(enderecos);
		empresa.setTelefones(telefones);
		empresa.setSite("rubens.com.br");

		System.out.println(empresa.toString());
	}

	@Test
	public void deve_aceitar_empresa_com_todos_os_campos_prechidos_e_corretos_exceto_site() {
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

		telefone.setDdd((byte) 11);
		telefone.setNumero(123456789);
		telefone.setRamal("1");
		telefone.setComplemento("Diretoria");
		telefones[0] = telefone;

		empresa.setNomeFantasia("Rubens");
		empresa.setEnderecos(enderecos);
		empresa.setTelefones(telefones);
		empresa.setSite(null);

		System.out.println(empresa.toString());
	}

	@Test
	public void deve_aceitar_empresa_com_todos_os_campos_prechidos_e_corretos_exceto_nome_fantasia() {
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

		telefone.setDdd((byte) 11);
		telefone.setNumero(123456789);
		telefone.setRamal("1");
		telefone.setComplemento("Diretoria");
		telefones[0] = telefone;

		empresa.setNomeFantasia(null);
		empresa.setEnderecos(enderecos);
		empresa.setTelefones(telefones);
		empresa.setSite("rubens.com.br");

		System.out.println(empresa.toString());
	}

	@Test
	public void deve_aceitar_empresa_com_todos_os_campos_prechidos_e_corretos_exceto_site_e_nome_fantasia() {
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

		telefone.setDdd((byte) 11);
		telefone.setNumero(123456789);
		telefone.setRamal("1");
		telefone.setComplemento("Diretoria");
		telefones[0] = telefone;

		empresa.setNomeFantasia(null);
		empresa.setEnderecos(enderecos);
		empresa.setTelefones(telefones);
		empresa.setSite(null);

		System.out.println(empresa.toString());
	}
	
}
