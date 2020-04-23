package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;

import Fenetre.Fenetre;

public class HomePageController implements ActionListener {

	public Fenetre fenetre;
	Connection cnx;
	
	HomePageController(Fenetre f, Connection cnx){
		
		this.fenetre = f;	
		this.cnx = cnx;
		fenetre.switchPannels(fenetre.Home);
		fenetre.getBtnCliquerIci().addActionListener(this);
		fenetre.getBtnCliquerIci_1().addActionListener(this);
		fenetre.getBtnCliquerIci_1_1().addActionListener(this);
		fenetre.getBtnCliquerIci_1_1_1().addActionListener(this);
		fenetre.getBtnCliquerIci_2().addActionListener(this);
		fenetre.getBtnCliquerIci_1_1_2().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton btn = (JButton) e.getSource();

		switch (btn.getName()) {
		case "nouvelle_location":
			
			try {
				NewLocationController newLocation = new NewLocationController(fenetre, cnx);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
		case "nouveau_collaborateur":
			
		 NewUserController newUser = new NewUserController(fenetre, cnx);
		 
		 break;
		 
		case "nouveau_parking":
			
			NewParkingController newParking = new NewParkingController(fenetre, cnx);
			
			break;
			
		case "afficher_collaborateurs":
			
			AfficherCollaborateursController afficherCollaborateur = new AfficherCollaborateursController(fenetre, cnx);
			
			break;
			
		case "afficher_parkings":
			
			AfficherParkingsController afficherParking = new AfficherParkingsController(fenetre, cnx);
			
			break;
			
		case "afficher_locations":
			
			System.out.println("yes");
			
			AfficherLocationsController afficherLocations= new AfficherLocationsController(fenetre, cnx);
			
			break;
			
		default:
			break;
		}
	}
}
