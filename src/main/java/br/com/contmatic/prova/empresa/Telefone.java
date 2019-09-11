package br.com.contmatic.prova.empresa;

public class Telefone {

	private Byte ddd;

	private Integer numero;

	private String ramal;

	private String complemento;

	public Telefone(Byte ddd, Integer numero, String ramal, String complemento) {
		this.setDdd(ddd);
		this.setNumero(numero);
		this.setRamal(ramal);
		this.setComplemento(complemento);
	}

	public Telefone() {
	}

	public byte getDdd() {
		return ddd;
	}

	public void setDdd(Byte ddd) {
		verificacaoDeDddNulo(ddd);
		verificacaoDeDddMenorQue11OuMaiorQue99(ddd);
		verificacaoDeDddDentroDoIntervalo11a99(ddd);
		this.ddd = ddd;
	}

	private void verificacaoDeDddNulo(Byte ddd) {
		if ((ddd == null)) {
			throw new NullPointerException("DDD e numero nao podem ser nulos");
		}
	}

	private void verificacaoDeDddDentroDoIntervalo11a99(byte ddd) {
		if (ddd >= 11 && ddd <= 99) {
			if ((ddd == 20) || (ddd == 23) || (ddd == 25) || (ddd == 26) || (ddd == 29) || (ddd == 30) || (ddd == 36)
					|| (ddd == 39) || (ddd == 40) || (ddd == 50) || (ddd == 52) || (ddd == 56) || (ddd == 57)
					|| (ddd == 58) || (ddd == 59) || (ddd == 70) || (ddd == 72) || (ddd == 76) || (ddd == 78)
					|| (ddd == 80) || (ddd == 90)) {
				throw new IllegalArgumentException("DDD invalido.");
			}
		}
	}

	private void verificacaoDeDddMenorQue11OuMaiorQue99(Byte ddd) {
		if ((ddd < 11) || (ddd > 99)) {
			throw new IllegalArgumentException("DDD invalido");
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		verificacaoDeNumeroNulo(numero);
		verificacaoDeNumeroCom8ou9digitos(numero);
		this.numero = numero;
	}

	private void verificacaoDeNumeroNulo(Integer numero) {
		if (numero == null) {
			throw new NullPointerException("Numero nao pode ser nulo");
		}
	}

	private void verificacaoDeNumeroCom8ou9digitos(Integer numero) {
		if ((numero < 10000000) || (numero > 999999999)) {
			throw new IllegalArgumentException("Numero invalido");
		} else {
		}
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		verificacaoDeRamalDiferenteDeNulo(ramal);
		this.ramal = ramal;
	}

	private void verificacaoDeRamalDiferenteDeNulo(String ramal) {
		if (ramal != null) {
			Integer.parseInt(ramal);
			if (Integer.parseInt(ramal) < 0 || (Integer.parseInt(ramal) > 99999999)) {
				throw new IllegalArgumentException("Ramal invalido");
			}
		}
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((ramal == null) ? 0 : ramal.hashCode());
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
		Telefone other = (Telefone) obj;
		if (ddd == null) {
			if (other.ddd != null)
				return false;
		} else if (!ddd.equals(other.ddd))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (ramal == null) {
			if (other.ramal != null)
				return false;
		} else if (!ramal.equals(other.ramal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [ddd=" + ddd + ", numero=" + numero + ", ramal=" + ramal + ", complemento=" + complemento
				+ "]";
	}
}
