package br.com.contmatic.prova.empresa;

import java.util.Arrays;

public class Empresa {

	private String nomeFantasia;

	private String razaoSocial;

	private String cnpj;

	private Endereco[] enderecos;

	private Telefone[] telefones;

	private String email;

	private String site;

	public Empresa(String nomeFantasia, String razaoSocial, String cnpj, Endereco[] enderecos, Telefone[] telefones,
			String email, String site) {
		super();
		this.setNomeFantasia(nomeFantasia);
		this.setRazaoSocial(razaoSocial);
		this.setCnpj(cnpj);
		this.setEnderecos(enderecos);
		this.setTelefones(telefones);
		this.setEmail(email);
		this.setSite(site);
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
		validarRazaoSocialNula(razaoSocial);
		this.razaoSocial = razaoSocial;
	}

	private void validarRazaoSocialNula(String razaoSocial) {
		if (razaoSocial == null) {
			throw new NullPointerException("Razão social não pode ser nula");
		}
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		validacaoDeCnpjNulo(cnpj);
		verificacaoDeCnpj0000000000000(cnpj);
		verificacaoDe14Digitos(cnpj);
		verificadorDigito13(cnpj);
		verificadorDigito14(cnpj);
		this.cnpj = cnpj;
	}

	public void verificadorDigito13(String CNPJ) {
		char dig13;
		int soma, i, resto, num, peso;
		soma = 0;
		peso = 2;
		for (i = 11; i >= 0; i--) {
			num = (int) (CNPJ.charAt(i) - 48);
			soma = soma + (num * peso);
			peso = peso + 1;
			if (peso == 10) {
				peso = 2;
			}
		}
		resto = soma % 11;
		if ((resto == 0) || (resto == 1)) {
			dig13 = '0';
		} else {
			dig13 = (char) ((11 - resto) + 48);
		}

		if (dig13 == CNPJ.charAt(12)) {
		} else {
			throw new IllegalArgumentException("CNPJ invalid, erro no decimo terceiro digito");
		}
	}

	public void verificadorDigito14(String CNPJ) {
		char dig14;
		int soma, i, resto, num, peso;
		soma = 0;
		peso = 2;
		for (i = 12; i >= 0; i--) {
			num = (int) (CNPJ.charAt(i) - 48);
			soma = soma + (num * peso);
			peso = peso + 1;
			if (peso == 10)
				peso = 2;
		}
		resto = soma % 11;
		if ((resto == 0) || (resto == 1)) {
			dig14 = '0';
		} else {
			dig14 = (char) ((11 - resto) + 48);
		}
		if ((dig14 == CNPJ.charAt(13))) {
		} else {
			throw new IllegalArgumentException("CNPJ invalid, erro no decimo terceiro digito");
		}
	}

	private void verificacaoDe14Digitos(String cnpj) {
		if (cnpj.length() != 14) {
			throw new IllegalArgumentException("CNPJ deve conter 14 digitos");
		}
	}

	private void verificacaoDeCnpj0000000000000(String cnpj) {
		if (cnpj == "00000000000000") {
			throw new IllegalArgumentException("Este cnpj nao e valido");
		}
	}

	private void validacaoDeCnpjNulo(String cnpj) {
		if (cnpj == null) {
			throw new NullPointerException("CNPJ nao pode ser nulo");
		}
	}

	public Endereco[] getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco[] enderecos) {
		validacaoEnderecoNulo(enderecos);
		this.enderecos = enderecos;
	}

	private void validacaoEnderecoNulo(Endereco[] enderecos) {
		if (enderecos == null) {
			throw new NullPointerException("Endereco não pode ser nulo");
		}
	}

	public Telefone[] getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefone[] telefones) {
		validacaoTelefonesNulos(telefones);
		this.telefones = telefones;
	}

	private void validacaoTelefonesNulos(Telefone[] telefones) {
		if (telefones == null) {
			throw new NullPointerException();
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		validacaoEmailNulo(email);
		verificadorDeArrobas(email);
		verificadorDeEspacos(email);
		this.email = email;
	}

	private void verificadorDeEspacos(String email) {
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == ' ') {
				throw new IllegalArgumentException("Email com espaços");
			}
		}
	}

	private void verificadorDeArrobas(String email) {
		byte contArroba = 0;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') {
				contArroba++;
			}
		}
		if (contArroba != 1) {
			throw new IllegalArgumentException("Email invalido");
		}
	}

	private void validacaoEmailNulo(String email) {
		if (email == null)
			throw new NullPointerException("Email nulo");
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		verificacaoDeEspacosNoSite(site);
		this.site = site;
	}

	private void verificacaoDeEspacosNoSite(String site) {
		if (site != null) {
			for (int i = 0; i < site.length(); i++) {
				if (site.charAt(i) == ' ')
					throw new IllegalArgumentException("Site nao pode conter espacos");
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
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
