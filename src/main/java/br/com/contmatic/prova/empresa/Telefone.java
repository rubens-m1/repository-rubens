package br.com.contmatic.prova.empresa;

public class Telefone {
	private byte ddd;			//OK
	private int numero;			//OK
	private String ramal; 		//OK
	private String complemento;	//OK
	
	public void listaDeTelefones() {
		
	}
	
	public byte getDdd() {
		return ddd;
	}

	public void setDdd(byte ddd) {
		this.ddd = ddd;
		if (ddd >= 11 && ddd <= 99) {
			if ((ddd == 20) || (ddd == 23) || (ddd == 25) || (ddd == 26) || (ddd == 29) || (ddd == 30) || (ddd == 36)
					|| (ddd == 39) || (ddd == 40) || (ddd == 50) || (ddd == 52) || (ddd == 56) || (ddd == 57)
					|| (ddd == 58) || (ddd == 59) || (ddd == 70) || (ddd == 72) || (ddd == 76) || (ddd == 78)
					|| (ddd == 80) || (ddd == 90)) {

				throw new IllegalArgumentException("DDD invalido.");

			} else {
			}

		} else {

			throw new IllegalArgumentException("DDD invalido.");
		}

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
		if (numero < 10000000 || numero > 999999999) {
			throw new IllegalArgumentException("Numero invalido");
		} else {
		}
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
		if (ramal == null) {
		} else {
			Integer.parseInt(ramal);
			if (Integer.parseInt(ramal) < 0|| (Integer.parseInt(ramal) > 99999999)) {
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
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ddd;
		result = prime * result + numero;
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
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (ddd != other.ddd)
			return false;
		if (numero != other.numero)
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
