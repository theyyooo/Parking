package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Security.Hash;

public class DAOUser {
	
	Connection cnx;
	
	public DAOUser(Connection cnx) {
		this.cnx = cnx;
	}
	
	public List<User> findAll() throws SQLException{
		
		String SQL = "SELECT * FROM user";
		PreparedStatement preparedStatement = cnx.prepareStatement(SQL);
		ResultSet result = preparedStatement.executeQuery();
		List<User> users = new ArrayList<>();
		
		while (result.next()) {
			User u = new User()
					.setId(result.getInt("id"))
					.setPrenom(result.getString("prenom"))
					.setNom(result.getString("nom"))
					.setMail(result.getString("mail"))
					.setMdp(result.getString("mdp"));
							
			users.add(u);
		}
		
		return users;
		
	}
	
	public User find(String nom) throws SQLException {
		
		String SQL = "SELECT * FROM user WHERE nom=?";
		PreparedStatement preparedStatement = cnx.prepareStatement(SQL);
		preparedStatement.setString(1,nom);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		
		User u = new User()
				.setId(result.getInt("id"))
				.setNom(result.getString("nom"))
				.setPrenom(result.getString("prenom"))
				.setMail(result.getString("mail"))
				.setMdp(result.getString("mdp"))
				;
		return u;

	}
	
	public void save(User u) throws SQLException {
		
		Hash var = new Hash(u.mdp);
		String hash = var.getHash();
		
		String SQL = "INSERT INTO user (nom, prenom, mail, mdp)"
				+ "VALUES (?, ?, ?, ?)";
		PreparedStatement preparedStatement = cnx.prepareStatement(SQL);
		preparedStatement.setString(1,u.getNom());
		preparedStatement.setString(2,u.getPrenom());
		preparedStatement.setString(3,u.getMail());
		preparedStatement.setString(4,hash);

		preparedStatement.executeQuery();
	}
	
	public Boolean check(String mail, String mdp) throws SQLException {
		
		Hash var = new Hash(mdp);
		String hash = var.getHash();
		
		String SQL = "SELECT * FROM user WHERE mail=? AND mdp = ?";
		PreparedStatement preparedStatement = cnx.prepareStatement(SQL);
		preparedStatement.setString(1,mail);
		preparedStatement.setString(2, hash);
		ResultSet result = preparedStatement.executeQuery();
		
		List<User> users = new ArrayList<>();
		
		while (result.next()) {
			User u = new User()
					.setId(result.getInt("id"))
					.setPrenom(result.getString("prenom"))
					.setNom(result.getString("nom"))
					.setMail(result.getString("mail"))
					.setMdp(result.getString("mdp"));
							
			users.add(u);
		}
		
		int connection = users.size();
		
		if(connection == 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
