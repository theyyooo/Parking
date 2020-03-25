package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;

import DAO.DAOUser;
import Fenetre.Fenetre;

public class MainController implements ActionListener {
	
	public Fenetre f;
	Connection cnx;
	
	
	public MainController(Connection cnx) {
		
		this.cnx = cnx;
		Fenetre f = new Fenetre();
		this.f = f;
		f.setVisible(true);
		
		f.getButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton btn = (JButton) e.getSource();

		switch (btn.getName()) {
		case "connection":
			
			String mail = f.getTextField_1().getText();
			String mdp = new String(f.getTextField_1_1().getPassword());
			
			if(mail.isEmpty() | mdp.isEmpty()) {
				f.getLblNewLabel_8_1().setText("Merci de remplir tout les champs");
			}
			else {
			
				DAOUser daoU = new DAOUser(cnx);
				
				try {
					Boolean connection = daoU.check(mail, mdp);
					if(connection == true) {
						HomePageController homepageController = new HomePageController(f, cnx);
					}
					else {
						f.getLblNewLabel_8_1().setText("Le mail et le mot de passe ne correspondent pas");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
					
		default:
			break;
		}
		
	}
}
