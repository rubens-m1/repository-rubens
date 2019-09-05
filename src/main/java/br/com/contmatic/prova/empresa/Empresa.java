package br.com.contmatic.prova.empresa;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Empresa {

	private String nomeFantasia; 	// OK
	private String razaoSocial; 	// OK
	private long cnpj; 				// OK
	private Endereco[] enderecos; 	// OK
	private Telefone[] telefones; 	// OK
	private String email; 			// OK
	private String site; 			// OK

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
		if (razaoSocial == null) {
			throw new NullPointerException("Razão social bão pode ser nula");
		}

	}

	public long getCnpj() {
		return cnpj;

	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
		
	}

	public Endereco[] getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco[] enderecos) {
		this.enderecos = enderecos;
		
	}

	public Telefone[] getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefone[] telefones) {
		this.telefones = telefones;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cnpj ^ (cnpj >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + Arrays.hashCode(enderecos);
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + Arrays.hashCode(telefones);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (cnpj != other.cnpj)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (!Arrays.equals(enderecos, other.enderecos))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (!Arrays.equals(telefones, other.telefones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empresa [nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj
				+ ", enderecos=" + Arrays.toString(enderecos) + ", telefones=" + Arrays.toString(telefones) + ", email="
				+ email + ", site=" + site + "]";
	}

}
