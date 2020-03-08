package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {

	private static Singleton instance = null;
	public Connection cnx;
	
	private Singleton() throws SQLException {
		cnx = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/Parking?user=theo&password=123+aze");
	}
	
	public static Singleton getInstance() throws SQLException{
		if ( instance == null ) {
			instance = new Singleton();
		}
		return instance;
	}
	
}