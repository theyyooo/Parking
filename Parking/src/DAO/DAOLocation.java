package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOLocation {
	
	Connection cnx;
	
	public DAOLocation(Connection cnx) {
		this.cnx = cnx;
	}
	
	public void save(Location l) throws SQLException {
		String SQL = "INSERT INTO location (user_id, parking_id, date_debut, date_fin, vehicule)"
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = cnx.prepareStatement(SQL);
		preparedStatement.setInt(1,l.getUser_id());
		preparedStatement.setInt(2,l.getParking_id());
		preparedStatement.setDate(3,(Date) l.getDate_debut());
		preparedStatement.setDate(4,(Date) l.getDate_fin());
		preparedStatement.setString(5,l.getVehicule());

		preparedStatement.executeQuery();
	}
}
