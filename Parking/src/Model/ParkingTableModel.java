package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import Controller.MainController;
import DAO.DAOParking;
import DAO.DAOUser;
import DAO.Parking;
import DAO.User;
import main.Singleton;

public class ParkingTableModel extends DefaultTableModel {
	
	private List<Parking> listeParkings = new ArrayList<Parking>();
	public static final String entetes[] = {"Nom", "Place voiture", "Place moto", "Place velo"};
	
	public ParkingTableModel() throws SQLException {

		this.getParkings();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return ParkingTableModel.entetes.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeParkings == null ? 0 : listeParkings.size();
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
				return this.listeParkings.get(ligne).getName();
			case 1:
				return this.listeParkings.get(ligne).getPlace_voiture();
			case 2:
				return this.listeParkings.get(ligne).getPlace_moto();
			case 3:
				return this.listeParkings.get(ligne).getPlace_velo();
		}
		return null;
	}
	
	public void getParkings() throws SQLException{
		
		this.listeParkings = getDAOParking().findAll();
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
	
	



