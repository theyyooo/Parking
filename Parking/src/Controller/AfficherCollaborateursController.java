package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import Fenetre.Fenetre;

public class AfficherCollaborateursController implements ActionListener {

	Connection cnx;
	public Fenetre fenetre;
	
	AfficherCollaborateursController(Fenetre fenetre, Connection cnx){
		this.cnx = cnx;
		this.fenetre = fenetre;
		System.out.println("ok");
		fenetre.switchPannels(fenetre.AfficherCollaborateurs);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}}
