package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mysql.jdbc.Connection;



import it.polito.tdp.corsi.db.DbConnect;

public class CorsiModel {

	
			
	
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
	
	public HashMap <String,Integer> cercaCorsoIscritti(int per) {
	HashMap <String,Integer> mappaCorsoIscritti = new HashMap <String,Integer>();
	Connection conn= DbConnect.getConnection();
	try {
		String query= "SELECT c.codins, c.nome, COUNT(*) AS tot from corso c,iscrizione i  WHERE i.codins=c.codins and c.pd= ? GROUP BY c.codins, c.nome";
		PreparedStatement st= conn.prepareStatement(query);
		st.setInt(1,per);
		ResultSet rs= st.executeQuery();
		while (rs.next()) {mappaCorsoIscritti.put(rs.getString("nome"),rs.getInt("tot"));}
	
			
	}catch (SQLException e) {}
	return mappaCorsoIscritti;
	}

	public HashMap<String, String> calcoloCds(String codins) {
				return null;
	}
	


	
	

}
