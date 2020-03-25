package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;

import DAO.DAOUser;
import DAO.User;
import Fenetre.Fenetre;

public class NewUserController implements ActionListener {
	
	public Fenetre fenetre;
	Connection cnx;
	
	NewUserController(Fenetre f, Connection cnx){
		
		this.fenetre = f;	
		this.cnx = cnx;
		fenetre.switchPannels(fenetre.NouveauUser);
		fenetre.getTextField_3().setText("");
		fenetre.getTextField_4().setText("");
		fenetre.getTextField_5().setText("");
		fenetre.getTextField_6().setText("");
		
		fenetre.getBtnNewButton_1().addActionListener(this);
		fenetre.getBtnRetour_1().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton btn = (JButton) e.getSource();

		switch (btn.getName()) {
		case "validation_user":
			
			String nom = fenetre.getTextField_3().getText();
			String prenom = fenetre.getTextField_4().getText();
			String mail = fenetre.getTextField_5().getText();
			String mdp = fenetre.getTextField_6().getText();
			
			if (nom.isBlank() | prenom.isBlank()) {
				if(nom.isBlank()) {
					fenetre.lblNewLabel_4.setText("le nom n'est pas rempli");
				}
				if(prenom.isBlank()) {
					fenetre.lblNewLabel_4.setText("le prenom n'est pas rempli");
				}
				if (nom.isBlank() | prenom.isBlank()) {
					fenetre.lblNewLabel_4.setText("le nom et le prenom ne sont pas rempli");
				}
			}
			else {
				if(mail.isBlank() & mdp.isBlank()) {
					DAOUser daoU = new DAOUser(cnx);
					User u = new User(nom, prenom, mail, mdp);
					try {
						daoU.save(u);
						HomePageController homepageController = new HomePageController(fenetre, cnx);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(mail.isBlank() == false & mdp.isBlank() == false){
					DAOUser daoU = new DAOUser(cnx);
					User u = new User(nom, prenom, mail, mdp);
					try {
						daoU.save(u);
						HomePageController homepageController = new HomePageController(fenetre, cnx);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					fenetre.lblNewLabel_4.setText("si votre utilisateur est un admin, merci de remplir les données entièrement");
				}
			}
				
			break;
		case "retour":

			HomePageController homepageController = new HomePageController(fenetre, cnx);
			
		default:
			break;
		}
		
	}

}
