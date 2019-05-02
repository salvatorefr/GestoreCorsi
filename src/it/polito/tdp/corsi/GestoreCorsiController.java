package it.polito.tdp.corsi;
import java.util.ArrayList;
import java.util.List;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.CorsiModel;
import model.Corso;
import model.Iscrizione;
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
	    void calcolaStatCorsi(ActionEvent event) {
	    	
	    
	    	this.txtresult.clear();
	     String corsoCercato =this.txtperiodo.getText();
	     
	     
	    List <Studente> statStud= new ArrayList<Studente>();
	    	statStud.addAll(model.cercaStudentiIscrittiAlCOrso(corsoCercato));
	    	for (Studente st:statStud) {
	    		this.txtresult.appendText(st.getCognome()+" "+st.getNome()+" "+st.getCds()+"\n");
	    	}
	    	}
	    
	    

	    @FXML
	    void cercaCorsi(ActionEvent event) {
List<Corso> stampaCorso=new ArrayList<Corso>();
List<Iscrizione> stampaIscrizioni=new ArrayList<Iscrizione>();
int periodo=0;
try {
 periodo=Integer.parseInt(this.txtperiodo.getText());
}catch ( NumberFormatException e) {}
this.txtresult.clear();
if (periodo!=1 && periodo!=2) {this.txtresult.appendText("il periodo può essere 1 o 2");return;}
stampaCorso.addAll(this.model.cercaCorso(periodo));
stampaIscrizioni.addAll(this.model.getIscritti());
this.txtresult.appendText(String.format("Corsi del %d periodo:\n",periodo));
for (int i=0;i<stampaCorso.size();i++) {
	int numeroIscritti=0;
	for (Iscrizione is:stampaIscrizioni) {
		if (is.getCodins().compareTo(stampaCorso.get(i).getCodice())==0)
				numeroIscritti++;
	}
	this.txtresult.appendText(stampaCorso.get(i).getNome()+" "+numeroIscritti+" iscritti\n");
}
	    }
	    @FXML
	    void initialize() {
	        assert txtresult != null : "fx:id=\"txtresult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert txtperiodo != null : "fx:id=\"txtperiodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert btnStatistiche != null : "fx:id=\"btnStatistiche\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";

	    }
}
