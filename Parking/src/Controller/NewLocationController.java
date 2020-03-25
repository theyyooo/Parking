package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import DAO.DAOLocation;
import DAO.DAOParking;
import DAO.DAOUser;
import DAO.Location;
import DAO.Parking;
import DAO.User;
import Fenetre.Fenetre;

public class NewLocationController implements ActionListener {

	public Fenetre fenetre;
	Connection cnx;
	
	NewLocationController(Fenetre f, Connection cnx) throws SQLException{
		
		this.fenetre = f;	
		this.cnx = cnx;
		fenetre.switchPannels(fenetre.NouvelleLocation);
		fenetre.comboBox.removeAllItems();	
		fenetre.comboBox_2.removeAllItems();	
		fenetre.getTextField().setText("");
		fenetre.getTextField_2().setText("");
		
		DAOParking daoP = new DAOParking(cnx);
		List <Parking> parkings = daoP.findAll();
		
		DAOUser daoU = new DAOUser(cnx);
		List <User> users = daoU.findAll();
		
		for (Parking parking : parkings) {
			fenetre.comboBox.addItem(parking.getName());
		}
		
		for (User user : users) {
			fenetre.comboBox_2.addItem(user.getNom());
		}
		fenetre.getBtnNewButton().addActionListener(this);
		fenetre.getBtnRetour().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton btn = (JButton) e.getSource();

		switch (btn.getName()) {
		case "validation_location":
			
			String nameParking = fenetre.comboBox.getSelectedItem().toString();
			String nameUser = fenetre.comboBox_2.getSelectedItem().toString();
			DAOParking daoP = new DAOParking(cnx);
			DAOUser daoU = new DAOUser(cnx);
			try {
				Parking parking = daoP.find(nameParking);
				
				User user = daoU.find(nameUser);
				
				String nameTransport = fenetre.comboBox_1.getSelectedItem().toString();
				
				String dateDebut = fenetre.getTextField().getText();
					
				String dateFin = fenetre.getTextField_2().getText();
				
				
				if(dateDebut.isBlank() | dateFin.isBlank()) {
					if(dateDebut.isBlank()) {
						fenetre.lblNewLabel_5.setText("merci de remplir la date de début");
					}
				    if(dateFin.isBlank()) {
						fenetre.lblNewLabel_5.setText("merci de remplir la date de fin");
					}
					if (dateDebut.isBlank() & dateFin.isBlank()) {
						fenetre.lblNewLabel_5.setText("merci de remplir la date de début et de fin");
					}
				}
				else {
				
					SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
					Date result = simple.parse(dateDebut);
					java.sql.Date date1 = new java.sql.Date(result.getTime());
					
					Date result2 = simple.parse(dateFin);
					java.sql.Date date2 = new java.sql.Date(result2.getTime());
					
					Location location = new Location(user.getId(), parking.getId(), date1, date2, nameTransport);
				
					DAOLocation daoL = new DAOLocation(cnx);
					daoL.save(location);
				
					HomePageController homepageController = new HomePageController(fenetre, cnx);
				}
			} 
			catch (SQLException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		
		case "retour":
				
			HomePageController homepageController = new HomePageController(fenetre, cnx);
			
		default:
			break;
		}
	}
}
