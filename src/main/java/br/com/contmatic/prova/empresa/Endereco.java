package br.com.contmatic.prova.empresa;

public class Endereco {

	private String logradouro;  //OK
	private int numero;         //OK
	private String cep;         //OK
	private String complemento; //OK
	private String bairro;      //OK
	private String cidade;      //OK
	private String estado;      //OK
	private String pais;        //OK
	private String tipo;		//OK

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		if (logradouro == null)
			throw new NullPointerException("O logradouro nao pode ser nulo");
		for (int i = 0; i < logradouro.length(); i++)
			if (!(Character.isLetter(logradouro.charAt(i)) || Character.isDigit(logradouro.charAt(i)) || (logradouro.charAt(i) == ' ')))
			throw new IllegalArgumentException("Nao pode caracteres especiais");
	}
			
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
		if (numero < 0) {
			throw new IllegalArgumentException("O numero nao pode ser menor de 0");

		} else {
		}
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
		if (cep == null) {
			throw new NullPointerException("Coloque o seu CEP");
		} else if (cep.length() == 8){
			Integer.parseInt(cep);
				if (Integer.parseInt(cep)<1) {
					throw new IllegalArgumentException("CEP invalido");
					
				}
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
		this.bairro = bairro;
		if (bairro == null) {
			throw new NullPointerException("Bairro nao pode ser nulo");
		}
		for (int i = 0; i < bairro.length();i++)
			if (!(Character.isLetter(bairro.charAt(i)) || (Character.isDigit(bairro.charAt(i))) || (bairro.charAt(i) == ' ')))
			throw new IllegalArgumentException("Nao pode conter caracteres especiais");
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
		if (cidade == null)
			throw new NullPointerException("Cidade nÃ£o pode ser nula");
		for (int i = 0; i < cidade.length(); i++)
			if (!(Character.isLetter(cidade.charAt(i)) || (cidade.charAt(i) == ' ')))
				throw new IllegalArgumentException("Cidade nao pode conter numeros e caracteres especiais");
				
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
		if(estado == null)
			throw new NullPointerException("Estado nÃ£o pode ser nulo");
		for (int i = 0; i < estado.length(); i++)
			if(!(Character.isLetter(estado.charAt(i)) || (estado.charAt(i) == ' ')))
				throw new IllegalArgumentException("Estado nao pode conter numeros e caracteres especiais");
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
		if (pais == null)
			throw new NullPointerException("Pais nÃ£o pode ser nulo");
		for (int i = 0; i < pais.length(); i++)
			if (!(Character.isLetter(pais.charAt(i)) || (pais.charAt(i) == ' ')))
				throw new IllegalArgumentException("Pais nao pode conter numeros e caracteres especiais");
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
		if (tipo == null)
			throw new NullPointerException("O tipo nao pode ser nulo");
		for(int i = 0; i <tipo.length();i++)
			if (!(Character.isLetter(tipo.charAt(i)) ||  (Character.isDigit(tipo.charAt(i))) || (tipo.charAt(i) == ' ')))
				throw new IllegalArgumentException("Tipo nao pode conter caracteres especiais");
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
//		result = prime * result + cep;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + numero;
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
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
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep != other.cep)
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numero != other.numero)
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
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
