package it.polito.tdp.alien;
import java.util.*;

public class Parola implements Comparable <String> {
private String parolaAliena;
private LinkedList<String> traduzioneLista=new LinkedList <String> ();

public Parola(String parolaAliena,String traduzione) {
	super();
	this.parolaAliena = parolaAliena;
	this.traduzioneLista.add(traduzione);
}

public void setParolaAliena(String parolaAliena) {
	this.parolaAliena = parolaAliena;
}

public String getParolaAliena() {
	return parolaAliena;
}

public LinkedList<String> getTraduzioneLista() {
	return traduzioneLista;
}

public void aggiungiTraduzioneLista(String s) {
	this.traduzioneLista.add(s);
}

public String descrivitiLista () {
	String cercata="";
	for(String s: traduzioneLista)
	{
		cercata=cercata+"\n"+s;
	}
	return cercata;
}

@Override
public int compareTo(String arg0) {
	return this.traduzioneLista.get(0).compareTo(arg0);
}
}
