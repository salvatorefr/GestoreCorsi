package it.polito.tdp.corsi.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;


import model.Iscrizione;

public class IscrizioneDAO {
private List <Iscrizione> iscritti= new ArrayList<Iscrizione>();
	public IscrizioneDAO() {
		
	Connection conn=DbConnect.getConnection();
	String querySql = "SELECT * FROM iscrizione";
	try{
		PreparedStatement st= conn.prepareStatement(querySql);
		ResultSet rs= st.executeQuery();
		while(rs.next()) {
			iscritti.add(new Iscrizione(rs.getInt("matricola"),rs.getString("codins")));
				}
		
	}catch (SQLException e) {e.printStackTrace();}
	try {
		conn.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	}

	
	public List <Iscrizione> listAll() {


return iscritti;
}

}
