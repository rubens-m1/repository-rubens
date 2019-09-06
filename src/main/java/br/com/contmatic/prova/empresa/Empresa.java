package br.com.contmatic.prova.empresa;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Empresa {

	private String nomeFantasia; 	
	private String razaoSocial; 	
	private Long cnpj; 				
	private Endereco[] enderecos; 	
	private Telefone[] telefones; 	
	private String email; 			
	private String site; 			

	public Empresa(long cnpj, String razaoSocial, Endereco[] enderecos, Telefone[] telefones, String email) {
		this.setCnpj(cnpj);
		this.setRazaoSocial(razaoSocial);
		this.setEnderecos(enderecos);
		this.setTelefones(telefones);
		this.setEmail(email);
	}
	
	public Empresa() {
		
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		if (this.razaoSocial == null) {
			throw new NullPointerException("Razão social não pode ser nula");
		}

	}

	public Long getCnpj() {
		return cnpj;

	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
		if (this.cnpj == null) {
			throw new NullPointerException("CNPJ nao pode ser nulo");
		}
		
	}

	public Endereco[] getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco[] enderecos) {
		this.enderecos = enderecos;
		if(enderecos ==null) {
			throw new NullPointerException();
		}
		
	}

	public Telefone[] getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefone[] telefones) {
		this.telefones = telefones;
		if(telefones ==null) {
			throw new NullPointerException();
		}
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		byte contArroba = 0;

		if (email == null)
			throw new NullPointerException("Email nulo");
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') {
				contArroba++;
			} else if (email.charAt(i) == ' ') {
				throw new IllegalArgumentException("Email com espaços");

			}
		}
		if (contArroba == 1) {
			this.email = email;
		} else {
			throw new IllegalArgumentException("Email invalido");
		}

	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
		if (site != null)
			for (int i = 0; i < site.length(); i++)
				if (site.charAt(i) == ' ')
					throw new IllegalArgumentException("Site nao pode conter espacos");

	}

	public boolean isCNPJ(String CNPJ) {

		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || CNPJ.equals("22222222222222")
				|| CNPJ.equals("33333333333333") || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
				|| CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") || CNPJ.equals("88888888888888")
				|| CNPJ.equals("99999999999999") || (CNPJ.length() != 14))
			return (false);

		char dig13, dig14;
		int sm, i, r, num, peso;

		try {

			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {

				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}


	@Override
	public String toString() {
		return "Empresa [nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj
				+ ", enderecos=" + Arrays.toString(enderecos) + ", telefones=" + Arrays.toString(telefones) + ", email="
				+ email + ", site=" + site + "]";
	}

}
