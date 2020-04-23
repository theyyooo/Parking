package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOParking{
	
	Connection cnx;
	
	public DAOParking(Connection cnx) {
		this.cnx = cnx;
	}
	
	public List<Parking> findAll() throws SQLException{
		
		String SQL = "SELECT * FROM parking";
		PreparedStatement preparedStatement = cnx.prepareStatement(SQL);
		ResultSet result = preparedStatement.executeQuery();
		List<Parking> parkings = new ArrayList<>();
		
		while (result.next()) {
			Parking p = new Parking()
					.setId(result.getInt("id"))
					.setPlace_voiture(result.getInt("place_voiture"))
					.setPlace_moto(result.getInt("place_moto"))
					.setPlace_velo(result.getInt("place_velo"))
					.setName(result.getString("nom"));
			parkings.add(p);
		}
		
		return parkings;
		
	}
	
	public Parking find(String name) throws SQLException {
		
		String SQL = "SELECT * FROM parking WHERE nom=?";
		PreparedStatement preparedStatement = cnx.prepareStatement(SQL);
		preparedStatement.setString(1,name);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		
		Parking p = new Parking()
				.setId(result.getInt("id"))
				.setName(result.getString("nom"))
				.setPlace_moto(result.getInt("place_moto"))
				.setPlace_velo(result.getInt("place_velo"))
				.setPlace_voiture(result.getInt("place_voiture"))
				;
		return p;

	}
	
	public void save(Parking p) throws SQLException {
		String SQL = "INSERT INTO parking (place_voiture, place_moto, place_velo, nom)"
				+ "VALUES (?, ?, ?, ?)";
		PreparedStatement preparedStatement = cnx.prepareStatement(SQL);
		preparedStatement.setInt(1,p.getPlace_voiture());
		preparedStatement.setInt(2,p.getPlace_moto());
		preparedStatement.setInt(3,p.getPlace_velo());
		preparedStatement.setString(4,p.getName());

		preparedStatement.executeQuery();
	}
	
	public Parking findById(int id) throws SQLException {
		
		String SQL = "SELECT * FROM parking WHERE id=?";
		PreparedStatement preparedStatement = cnx.prepareStatement(SQL);
		preparedStatement.setInt(1,id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		
		Parking p = new Parking()
				.setId(result.getInt("id"))
				.setName(result.getString("nom"))
				.setPlace_moto(result.getInt("place_moto"))
				.setPlace_velo(result.getInt("place_velo"))
				.setPlace_voiture(result.getInt("place_voiture"))
				;
		return p;

	}
}
