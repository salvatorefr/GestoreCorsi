package model;

import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.IscrizioneDAO;
import it.polito.tdp.corsi.db.StudenteDAO;

public class CorsiModel {

	public List<Corso> cercaCorso(int parseInt) {
	return CorsoDAO.getCorsiPeriodo(parseInt);
	
	}
	public List<Iscrizione> getIscritti() {
		IscrizioneDAO ida= new IscrizioneDAO();
		return ida.listAll();
	}
	public List<Studente> getStudenti(){
		StudenteDAO sd =new StudenteDAO();
		return sd.getStudenti();
	}
	public List<Corso> getCorsi() {
		CorsoDAO corsi= new CorsoDAO();
		return corsi.getCorsiAll();
		
	}


	
	

}
