package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTable;

import DAO.DAOUser;
import Fenetre.Fenetre;
import Model.LocationTableModel;
import Model.UserTableModel;

public class AfficherLocationsController implements ActionListener {

	Connection cnx;
	public Fenetre fenetre;
	
	AfficherLocationsController(Fenetre fenetre, Connection cnx){
		this.cnx = cnx;
		this.fenetre = fenetre;
		fenetre.switchPannels(fenetre.AfficherLocations);
		this.loadData();
		
		fenetre.getBtnRetour_2_3().addActionListener(this);
	}
	
	
	public void loadData() {
		LocationTableModel locationTableModel;
		try {
			locationTableModel = new LocationTableModel();
			JTable table = this.fenetre.getTable_2();
			table.setModel(locationTableModel);
			table.repaint();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//DefaultTableModel model = 
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton btn = (JButton) e.getSource();
		
		switch (btn.getName()) {
		
		case "retour":
			
			HomePageController homepageController = new HomePageController(fenetre, cnx);
			
		default:
			break;
		
		}

		
	}
}
		

