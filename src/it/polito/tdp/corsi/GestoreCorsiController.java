package it.polito.tdp.corsi;

import java.util.HashMap;
import java.util.List;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.CorsiModel;
import model.Studente;



public class GestoreCorsiController {
	
	
	CorsiModel model;

	public void setModel(CorsiModel model) {
		this.model=model;
		
	}
	
	  @FXML
	  
	    private TextArea txtresult;

	    @FXML
	    private TextField txtperiodo;

	    @FXML
	    private Button btnCercaCorsi;

	    @FXML
	    private Button btnStatistiche;
	  
	    @FXML
	    private TextField inputcds;

	    @FXML
	    private Button statistichecds;


	    @FXML
	    void elencaStudenti(ActionEvent event) {
	    	
	    
	    	this.txtresult.clear();
	     String corsoCercato =this.inputcds.getText();
	     List <Studente> iscritti= model.cercaStudentiIscrittiAlCOrso(corsoCercato);
	     for (Studente st:iscritti) {
	    	 this.txtresult.appendText(st.getNome()+" "+st.getCognome()+"\n");
	    	 
	     }
	  
	    	}
	    
	    

	    @FXML
	    void cercaCorsi(ActionEvent event) {
	    	int periodo=0;
			try {
			 periodo=Integer.parseInt(this.txtperiodo.getText());
			}catch ( NumberFormatException e) {}
			this.txtresult.clear();
			if (periodo!=1 && periodo!=2) {this.txtresult.appendText("il periodo può essere 1 o 2");return;}
			else { HashMap<String,Integer> stampa= model.cercaCorsoIscritti(periodo);
			for(String key:stampa.keySet()) {
			this.txtresult.appendText(key+" "+ stampa.get(key)+"\n");
			}
}
	    }
	    @FXML
	    void initialize() {
	        assert txtresult != null : "fx:id=\"txtresult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert txtperiodo != null : "fx:id=\"txtperiodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert btnStatistiche != null : "fx:id=\"btnStatistiche\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";

	    }
	    @FXML
	    void calcolaStatistichecds(ActionEvent event) {
	    	this.txtresult.clear();
	    	String codinst= inputcds.getText();
	    	HashMap <String,String> statcds= new HashMap<String,String>();
	    	statcds= model.calcoloCds(codinst);

	    }

}
