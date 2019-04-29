package model;

public class Iscrizione {
	@Override
	public String toString() {
		return "Iscrizione [matricola=" + matricola + ", codins=" + codins + "]";
	}

	private int  matricola;
private String codins;

public int getMatricola() {
	return matricola;
}

public void setMatricola(int matricola) {
	this.matricola = matricola;
}

public String getCodins() {
	return codins;
}

public void setCodins(String codins) {
	this.codins = codins;
}

public Iscrizione(int matricola, String codins) {
	super();
	this.matricola = matricola;
	this.codins = codins;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codins == null) ? 0 : codins.hashCode());
	result = prime * result + matricola;
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
	Iscrizione other = (Iscrizione) obj;
	if (codins == null) {
		if (other.codins != null)
			return false;
	} else if (!codins.equals(other.codins))
		return false;
	if (matricola != other.matricola)
		return false;
	return true;
}


}
