package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
public List<Location> findAll() throws SQLException{
		
		String SQL = "SELECT * FROM location";
		PreparedStatement preparedStatement = cnx.prepareStatement(SQL);
		ResultSet result = preparedStatement.executeQuery();
		List<Location> locations = new ArrayList<>();
		
		while (result.next()) {
			Location l = new Location()
					.setId(result.getInt("id"))
					.setUser_id(result.getInt("user_id"))
					.setParking_id(result.getInt("parking_id"))
					.setDate_debut(result.getDate("date_debut"))
					.setDate_fin(result.getDate("date_fin"))
					.setVehicule(result.getString("vehicule"));
			locations.add(l);
			System.out.println(l.getParking_id());
		}
		
		return locations;

	}
}
