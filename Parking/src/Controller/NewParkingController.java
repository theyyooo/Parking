package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;

import DAO.DAOParking;
import DAO.Parking;
import Fenetre.Fenetre;

public class NewParkingController implements ActionListener {
	
	public Fenetre fenetre;
	Connection cnx;
	
	NewParkingController(Fenetre f, Connection cnx){
		
		this.fenetre = f;	
		this.cnx = cnx;
		fenetre.switchPannels(fenetre.NouveauParking);
		fenetre.getTextField_7().setText("");
		fenetre.getTextField_8().setText("");
		fenetre.getTextField_9().setText("");
		fenetre.getTextField_10().setText("");
		
		fenetre.getBtnNewButton_2().addActionListener(this);
		fenetre.getBtnRetour_2().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton btn = (JButton) e.getSource();

		switch (btn.getName()) {
		case "validation_parking":
			
			String place_voiture_string = fenetre.getTextField_7().getText();
			String place_moto_string = fenetre.getTextField_8().getText();
			String place_velo_string = fenetre.getTextField_9().getText();
			String nom = fenetre.getTextField_10().getText();
			
			if (place_voiture_string.isBlank() | place_moto_string.isBlank() | place_velo_string.isBlank() | nom.isBlank()) {
				if(place_voiture_string.isBlank()) {
					fenetre.lblNewLabel_8.setText("le nombre de voiture n'est pas rempli");
				}
				else if(place_moto_string.isBlank()) {
					fenetre.lblNewLabel_8.setText("le nombre de moto n'est pas rempli");
				}
				else if (place_velo_string.isBlank()) {
					fenetre.lblNewLabel_8.setText("le nombre de velo n'est pas rempli");
				}
				else if (nom.isBlank()) {
					fenetre.lblNewLabel_8.setText("le nom du parking n'est pas rempli");
				}
			}
			else {
				int place_voiture = Integer.parseInt(place_voiture_string);
				int place_moto = Integer.parseInt(place_moto_string);
				int place_velo = Integer.parseInt(place_velo_string)
						
;				DAOParking daoP = new DAOParking(cnx);
				Parking parking = new Parking(place_voiture, place_moto, place_velo, nom);
				try {
					daoP.save(parking);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				HomePageController homepageController = new HomePageController(fenetre, cnx);	
			}
				
			break;
		case "retour":

			HomePageController homepageController = new HomePageController(fenetre, cnx);
			
		default:
			break;
		}
		
	}

}
