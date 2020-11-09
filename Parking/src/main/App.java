package main;

import java.sql.Connection;
import java.sql.SQLException;

import Controller.MainController;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Connection cnx = Singleton.getInstance().cnx;
			System.out.println("Connexion ok");
			MainController main = new MainController(cnx);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
