package br.com.contmatic.prova.empresa;

public class Endereco {

	private String logradouro;

	private Integer numero;

	private String cep;

	private String complemento;

	private String bairro;

	private String cidade;

	private String estado;

	private String pais;

	private String tipo;

	public Endereco(String logradouro, Integer numero, String cep, String complemento, String bairro, String cidade,
			String estado, String pais, String tipo) {
		super();
		validacaoNumeroMenorQueZero(numero);
		validacaoDeQualquerCampoNulo(logradouro, numero, cep, complemento, bairro, cidade, estado, pais, tipo);
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setCep(cep);
		this.setComplemento(complemento);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setPais(pais);
		this.setTipo(tipo);
	}

	private void validacaoDeQualquerCampoNulo(String logradouro, Integer numero, String cep, String complemento,
			String bairro, String cidade, String estado, String pais, String tipo) {
		if ((logradouro == null) || (numero == null) || (cep == null) || (complemento == null) || (bairro == null)
				|| (cidade == null) || (estado == null) || (pais == null) || (tipo == null)) {
			throw new NullPointerException("Falta preencher algum campo obrigatorio");
		}
	}

	private void validacaoNumeroMenorQueZero(Integer numero) {
		if (numero < 0) {
			throw new IllegalArgumentException("O numero não pode ser negativo");
		}
	}

	public Endereco() {
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		validacaoDeCaracteresEspeciais(logradouro);
		this.logradouro = logradouro;
	}

	private void validacaoDeCaracteresEspeciais(String logradouro) {
		for (int i = 0; i < logradouro.length(); i++) {
			if (!(Character.isLetter(logradouro.charAt(i)) || Character.isDigit(logradouro.charAt(i))
					|| (logradouro.charAt(i) == ' ')))
				throw new IllegalArgumentException("Nao pode caracteres especiais");
		}
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		validacaoNumeroMenorQueZero(numero);
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		validacaoDeCepComOitoDigitos(cep);
		validacaoDoIntervaloDosCeps(cep);
		this.cep = cep;
	}

	private void validacaoDoIntervaloDosCeps(String cep) {
		if ((Integer.parseInt(cep) < 00000001) || (Integer.parseInt(cep) > 99999999)) {
			throw new IllegalArgumentException("CEP invalido");
		}
	}

	private void validacaoDeCepComOitoDigitos(String cep) {
		if (cep.length() == 8) {
			Integer.parseInt(cep);
		} else {
			throw new IllegalArgumentException("CEP invalido");
		}
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		verificacaoDeCaracteresEspeciais(bairro);
		this.bairro = bairro;
	}

	private void verificacaoDeCaracteresEspeciais(String bairro) {
		for (int i = 0; i < bairro.length(); i++) {
			if (!(Character.isLetter(bairro.charAt(i)) || (Character.isDigit(bairro.charAt(i)))
					|| (bairro.charAt(i) == ' '))) {
				throw new IllegalArgumentException("Não pode conter caracteres especiais");
			}
		}
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		verificacaoDeCaracteresEspeciaisENumeros(cidade);
		this.cidade = cidade;
	}

	private void verificacaoDeCaracteresEspeciaisENumeros(String cidade) {
		for (int i = 0; i < cidade.length(); i++) {
			if (!(Character.isLetter(cidade.charAt(i)) || (cidade.charAt(i) == ' '))) {
				throw new IllegalArgumentException("Cidade não pode conter números e caracteres especiais");
			}
		}
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		verificacaoDeCaracteresEspeciaisENumeros(estado);
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		verificacaoDeCaracteresEspeciaisENumeros(pais);
		this.pais = pais;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		verificacaoDeCaracteresEspeciais(tipo);
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", cep=" + cep + ", complemento="
				+ complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais
				+ ", tipo=" + tipo + "]";
	}
}
