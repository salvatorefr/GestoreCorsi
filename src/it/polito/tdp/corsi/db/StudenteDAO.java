package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Studente;

public class StudenteDAO {
	List <Studente>  studenti=new ArrayList<Studente>();
	
	public StudenteDAO() {
    Connection conn=DbConnect.getConnection();
    String query="select * from studente";
   
    try {
    	PreparedStatement st= conn.prepareStatement(query);
    	ResultSet rs= st.executeQuery();
    	while(rs.next()) {
    		studenti.add(new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS")));
    	}
    	conn.close();
    	
    }catch(SQLException e) {e.printStackTrace();}
		
	}
	public List<Studente> getStudenti(){
		return studenti;
	}

}
