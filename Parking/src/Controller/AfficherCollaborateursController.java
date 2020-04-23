package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.DAOUser;
import DAO.User;
import Fenetre.Fenetre;
import Model.UserTableModel;

public class AfficherCollaborateursController implements ActionListener {

	Connection cnx;
	public Fenetre fenetre; 
	private UserTableModel userTableModel;
	private List<User> collaborateurs;
	private DAOUser dao;
	
	AfficherCollaborateursController(Fenetre fenetre, Connection cnx){
		this.cnx = cnx;
		this.fenetre = fenetre;
		fenetre.switchPannels(fenetre.AfficherCollaborateurs);
		this.loadData();
		
		fenetre.getBtnRetour_2_1().addActionListener(this);
		fenetre.getBtnRetour_2_1_1().addActionListener(this);
	}
	
	
	public void loadData() {
		try {
			this.dao = new DAOUser(cnx);
			this.collaborateurs = dao.findAll();
			this.userTableModel = new UserTableModel(this.collaborateurs);
			JTable table = this.fenetre.getTable();
			table.setModel(this.userTableModel);
			table.repaint();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton btn = (JButton) e.getSource();
		
		switch (btn.getName()) {
		
		case "retour":
			
			HomePageController homepageController = new HomePageController(fenetre, cnx);
			break;
			
		case "supprimer":
			JTable table = fenetre.getTable();
			int row = table.getSelectedRow();
			if (row == -1)
			{
				JOptionPane.showMessageDialog(fenetre, "Merci de selectionner une ligne");
				break ;
			}
			User user = userTableModel.getUserAt(row);
			userTableModel.setRowCount(userTableModel.getRowCount()-1);
			this.collaborateurs.remove(row);
			userTableModel.fireTableDataChanged();
			try {
				this.dao.delete(user);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default:
			break;
		
		}

		
	}
}
		
