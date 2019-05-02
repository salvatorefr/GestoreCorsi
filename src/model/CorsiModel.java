package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;


import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.DbConnect;
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
	public List <Studente> cercaStudentiIscrittiAlCOrso(String corsoCercato){
	List<Studente> ritorno=new ArrayList<Studente>();
		Connection conn= DbConnect.getConnection();
	try {String query= "	SELECT matricola,nome,cognome,cds from studente AS s 	WHERE s.matricola IN (SELECT matricola FROM iscrizione AS i WHERE i.codins IN ( SELECT codins FROM corso WHERE nome= ? )) 	ORDER BY cds";
	PreparedStatement st= conn.prepareStatement(query);
	st.setString(1, corsoCercato);
	ResultSet rs= st.executeQuery();
	while (rs.next()) {
		Studente nuovoStudente = new Studente(rs.getInt(1),rs.getString(3),rs.getString(2),rs.getString(4));
		ritorno.add(nuovoStudente);
		
	}
	
	
	}catch (SQLException e) {}
	
	return ritorno;
	
	
	}
	


	
	

}
