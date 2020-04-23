package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import Controller.MainController;
import DAO.DAOLocation;
import DAO.DAOParking;
import DAO.DAOUser;
import DAO.Location;
import DAO.Parking;
import DAO.User;
import main.Singleton;

public class LocationTableModel extends DefaultTableModel {
	
	private List<Location> listeLocation = new ArrayList<Location>();
	public static final String entetes[] = {"Prenom", "Nom", "User Id", "Nom Parking", "Parking Id", "Date début", "Date fin", "type de véhicule"};
	
	public LocationTableModel() throws SQLException {

		this.getLocations();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return LocationTableModel.entetes.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeLocation == null ? 0 : listeLocation.size();
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

			try {
				User user =  getUser(this.listeLocation.get(ligne).getUser_id());
				return user.getPrenom();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			case 1:

			try {
				User user =  getUser(this.listeLocation.get(ligne).getUser_id());
				return user.getNom();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			case 2:
				return this.listeLocation.get(ligne).getUser_id();
			case 3:
				try {
					Parking parking =  getParking(this.listeLocation.get(ligne).getParking_id());
					return parking.getName();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 4:
				return this.listeLocation.get(ligne).getParking_id();
			case 5:
				return this.listeLocation.get(ligne).getDate_debut();
			case 6:
				return this.listeLocation.get(ligne).getDate_fin();
			case 7:
				return this.listeLocation.get(ligne).getVehicule();
		}
		return null;
	}
	
	public void getLocations() throws SQLException{
		
		this.listeLocation = getDAOLocation().findAll();
	}
	
	public User getUser(int id) throws SQLException{
		User user = getDAOUser().findById(id);
		return user;
	}
	
	public Parking getParking(int id) throws SQLException{
		Parking parking = getDAOParking().findById(id);
		return parking;
	}
	
	public DAOLocation getDAOLocation() {
	
		try {
			Connection cnx = Singleton.getInstance().cnx;
			return new DAOLocation(cnx);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	
	public DAOParking getDAOParking() {
		
		try {
			Connection cnx = Singleton.getInstance().cnx;
			return new DAOParking(cnx);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
	
	



