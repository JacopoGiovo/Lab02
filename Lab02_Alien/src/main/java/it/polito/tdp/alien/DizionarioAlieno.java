package it.polito.tdp.alien;
import java.util.*;

public class DizionarioAlieno {
  Map <String,Parola> parole = new TreeMap <String,Parola>();

   public void aggiungiParola(String parolaAliena,String traduzione){
	  Parola ptemp=new Parola (parolaAliena,traduzione);
	  if(parole.containsKey(parolaAliena))
	  {
		 // RISOLUZIONE PRIMA PARTE 
		 // parole.remove(parolaAliena);
		 // ptemp.setTraduzione(traduzione);
		 //  parole.put(parolaAliena, ptemp);
		  
		 // RISOLUZIONE SECONDA PARTE
		LinkedList <String> daAggiungere=parole.get(parolaAliena).getTraduzioneLista();  
		if(!daAggiungere.contains(traduzione))
		{
			Parola considerata=parole.get(parolaAliena);
			considerata.aggiungiTraduzioneLista(traduzione);
			Collections.sort(considerata.getTraduzioneLista());
			
		}
	  }
	  else 
	  parole.put(parolaAliena,ptemp);
    }
   
   public String traduciParola(String parolaAliena) {
	   
	 // RISOLUZIONE PRIMA PARTE
	 // String cercata="";
	 // Parola ptemp=parole.get(parolaAliena);
	 //  if(ptemp != null)
	 //  {
	 //	   cercata=ptemp.getTraduzione();
     //	   return cercata;
	 //  }
	 //  else return null;
	  
	   Parola ptemp=parole.get(parolaAliena);
	   String stringaCercata="";
		   if(ptemp != null)
		  {
			stringaCercata=ptemp.descrivitiLista();
			return stringaCercata;
		   }
		 else return null;
   }
   
   public void rimuoviDizionario()
   {
	   parole.clear();
   }
   
   @Override
   public boolean equals(Object arg0) {
   	// TODO Auto-generated method stub
   	return super.equals(arg0);
   }
}
