package it.polito.tdp.corsi.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import model.Corso;

public class CorsoDAO {
	List<Corso> corsi;
	public CorsoDAO(){
		corsi = new ArrayList<Corso>();
		Connection conn=DbConnect.getConnection();
		String querySql="SELECT * FROM corso";
		try {
		PreparedStatement st= conn.prepareStatement(querySql);
		
		ResultSet rs= st.executeQuery();
		while (rs.next())  {
			Corso c= new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
			corsi.add(c);
		
			
		}
		conn.close();	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public static List<Corso>getCorsiPeriodo(int p){
		
		List<Corso> corsiSelected = new ArrayList<Corso>();
		Connection conn=DbConnect.getConnection();
		String querySql="SELECT * FROM corso WHERE pd=?";
		try {
		PreparedStatement st= conn.prepareStatement(querySql);
		st.setInt(1,p);
		ResultSet rs= st.executeQuery();
		while (rs.next())  {
			Corso c= new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
			corsiSelected.add(c);
		
			
		}
		conn.close();	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return corsiSelected;
	}

	public List<Corso> getCorsiAll() {
		return corsi;
		
	}
	

}
