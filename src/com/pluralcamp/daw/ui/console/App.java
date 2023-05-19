package com.pluralcamp.daw.ui.console;
import com.pluralcamp.daw.persistence.daos.impl.jdbc.ColorDAOJDBCImpl;
import com.pluralcamp.daw.persistence.daos.impl.jdbc.EmployeeDAOJDBCImpl;
import com.pluralcamp.daw.persistence.daos.impl.jdbc.EventDAOJDBCImpl;
import com.pluralcamp.daw.persistence.exceptions.DAOException;
import com.pluralcamp.daw.entities.core.Color;

import java.util.List;
//import java.awt.Color;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    	
    	Scanner stdin = new Scanner(System.in);
    	
    	ColorDAOJDBCImpl colorDAOJDBC = new ColorDAOJDBCImpl();
    	EventDAOJDBCImpl eventDAOJDBC = new EventDAOJDBCImpl();

        try {
        	Color c = colorDAOJDBC.getColorById(5);
        	if(c != null) {
        		System.out.println(c.toString());
        	}
        }
        catch(DAOException ex) {
        	System.out.printf("Error:: %s %n", ex.getMessage());
        	
        }
        
        System.out.println("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        try{
        	List<Color> colors = colorDAOJDBC.getColors();
        	for(Color c: colors) {
        		System.out.println(c.toString());
        	}
        }catch(DAOException ex) {
        	System.out.printf("Error:: %s %n", ex.getMessage());
        }
        
        System.out.println("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        
    }
}
