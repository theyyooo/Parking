package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import Controller.MainController;
import DAO.DAOUser;
import DAO.User;
import main.Singleton;

public class UserTableModel extends DefaultTableModel {
	
	private List<User> listeCollabo = new ArrayList<User>();
	public static final String entetes[] = {"Nom", "prenom", "mail"};
	
	public UserTableModel(List<User> liste) {
		this.listeCollabo = liste;
	}
	
	public UserTableModel() throws SQLException {
		this.getUsers();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return UserTableModel.entetes.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeCollabo == null ? 0 : listeCollabo.size();
		//return this.listeCollabo.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return entetes[column];
	}

	@Override
	public Object getValueAt(int ligne, int column) {
		// TODO Auto-generated method stub
		switch (column) {
			case 0:
				return this.listeCollabo.get(ligne).getNom();
			case 1:
				return this.listeCollabo.get(ligne).getPrenom();
			case 2:
				return this.listeCollabo.get(ligne).getMail();
		}
		return null;
	}
	
	public void getUsers() throws SQLException{
		
		this.listeCollabo = getDAOUser().findAll();
	}
	
	public DAOUser getDAOUser() {
	
		try {
			Connection cnx = Singleton.getInstance().cnx;
			return new DAOUser(cnx);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUserAt(int index) {
		return this.listeCollabo.get(index);
	}
		
		
}
	
	


