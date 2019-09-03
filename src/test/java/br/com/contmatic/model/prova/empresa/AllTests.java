package br.com.contmatic.model.prova.empresa;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CnpjTest.class, EmailTest.class, EnderecoTest.class, NomeFantasia.class, SiteTest.class, RazaoSocialTest.class,
		TelefoneTest.class})
public class AllTests {
	@AfterClass
	public static void fim_dos_testes_de_cnpj() {
		System.out.println("-------------------------");
		System.out.println("FIM DE TODOS OS TESTES");
		System.out.println("--------------------------");
	}


}

