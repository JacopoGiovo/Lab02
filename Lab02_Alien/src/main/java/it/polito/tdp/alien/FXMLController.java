package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
    DizionarioAlieno dizionario;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserireTesto;

    @FXML
    private Button btnTraduci;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Button btnRipulisci;

    @FXML
    void doReset(ActionEvent event) {
    	dizionario.rimuoviDizionario();
    	txtOutput.setText("");
    	txtOutput.setText("DIZIONARIO SVUOTATO!\n");

    }

    @FXML
    void doTraduci(ActionEvent event) {
    	if(txtInserireTesto.getText().compareTo(" ")!=0 || txtInserireTesto.getText().compareTo("")!=0)
    	{
    		String inserita= txtInserireTesto.getText();
    		if(this.parolaValida(inserita)==true)
    	    {
    			if(inserita.contains(" "))
        		{
        			int a=inserita.indexOf(" ");
        			String parolaAliena=inserita.substring(0, a).toLowerCase();
        			String traduzione=inserita.substring(a+1).toLowerCase();
        			dizionario.aggiungiParola(parolaAliena,traduzione);
        			txtOutput.setText("Traduzione inserita nel dizionario!\n");
        		}
    			else
    			{
        			String parolaAliena = txtInserireTesto.getText().toLowerCase();
        			String traduzione= dizionario.traduciParola(parolaAliena);
        			txtOutput.setText("");
        			txtOutput.setText("La parola tradotta ha la/le seguente/i traduzione/i: "+traduzione+"\n");
        		}
    	    }
    		else
    		{

    			txtOutput.setText("INSERIRE SOLO CARATTERI,NON SONO AMMESSI NUMERI E CARATTERI SPECIALI!\n");
    			return;
    		}
    	}
    	

    }
    public boolean parolaValida(String parola)
    {
        for(int i=0;i<parola.length()-1;i++)
        {
            if((Character.isLetter(parola.charAt(i))==true) || (" ".compareTo(""+parola.charAt(i))==0 && " ".compareTo(""+parola.charAt(i+1))!=0))
            parola.toLowerCase();
            else return false;
            if(Character.isLetter(parola.charAt(parola.length()-1))==false)
            return false;
        }
    	return true;
    }

    @FXML
    void initialize() {
        assert txtInserireTesto != null : "fx:id=\"txtInserireTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTraduci != null : "fx:id=\"btnTraduci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRipulisci != null : "fx:id=\"btnRipulisci\" was not injected: check your FXML file 'Scene.fxml'.";
        dizionario=new DizionarioAlieno();
    }
}
