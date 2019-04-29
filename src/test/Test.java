package test;


import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;
import model.Corso;

public class Test {

	public static void main(String[] args) {
		List<Corso> c=new ArrayList<Corso>();

c.addAll(CorsoDAO.getCorsiPeriodo(2));
System.out.println(c.toString());


	}

}
