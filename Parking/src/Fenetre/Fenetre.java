package Fenetre;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.User;
import Model.UserTableModel;

import java.awt.Font;
import java.awt.TextField;
import java.text.DateFormat;
import java.text.Format;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.Color;

public class Fenetre extends JFrame {
	
//Connexion
	public JPanel Connection;
	private JPasswordField textField_1_1;
	private TextField textField_1;
	private JLabel lblNewLabel_8_1;
	private JButton button;
//Home
	public JPanel Home;
	private JButton btnCliquerIci;
	private JButton btnCliquerIci_1;
	private JButton btnCliquerIci_1_1;
	private JButton btnCliquerIci_1_1_1;
	private JButton btnCliquerIci_1_1_2;
	private JLabel lblTouteLesLocations;
	private JButton btnCliquerIci_2;
//Nouvelle Location
	public JPanel NouvelleLocation;
	private JButton btnRetour;
	private JLabel lblNewLabel_1;
	public JComboBox comboBox;
	public JComboBox comboBox_1;
	private JTextField textField;
	private JTextField textField_2;
	public JComboBox comboBox_2;
	public JLabel lblNewLabel_5;
	private JButton btnNewButton;
//Nouveau User
	public JPanel NouveauUser;
	private JButton btnRetour_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public JLabel lblNewLabel_4;
	private JButton btnNewButton_1;
//Nouveau Parking
	public JPanel NouveauParking;
	private JButton btnRetour_2;
	private JLabel lblNouveauParking;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_1_2;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JButton btnNewButton_2;
	public JLabel lblNewLabel_8;
//Afficher user
	public JPanel AfficherCollaborateurs;
	private JTable table;
	private JPanel panel_1;
	private JButton btnRetour_2_1;
//Afficher Parking
	public JPanel AfficherParkings;
	private JTable table_1;
	private JPanel panel_2;
	private JButton btnRetour_2_2;

//Afficher Locations
	public JPanel AfficherLocations;
	private JTable table_2;
	private JPanel panel_3;
	private JButton btnRetour_2_3;
//Autres	
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JButton btnRetour_2_1_1;






	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPannels(JPanel panel) {
		  layeredPane.removeAll();
		  layeredPane.add(panel);
		  layeredPane.repaint();
		  layeredPane.revalidate();
		}
	
	/**
	 * Create the frame.
	 */
	public Fenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 100, 1000, 400);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		Connection = new JPanel();
		Connection.setBounds(0, 100, 1000, 400);
		layeredPane.add(Connection);
		Connection.setLayout(null);
		
		textField_1 = new TextField();
		textField_1.setBounds(375, 150, 250, 40);
		Connection.add(textField_1);
		
		button = new JButton("Connexion");
		button.setBounds(425, 400, 150, 50);
		button.setName("connection");
		Connection.add(button);
		
		Label label = new Label("Email:");
		label.setBounds(0, 100, 1000, 30);
		Connection.add(label);
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		label.setAlignment(Label.CENTER);
		
		Label label_1 = new Label("Mot de passe: ");
		label_1.setBounds(0, 250, 1000, 30);
		Connection.add(label_1);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		label_1.setAlignment(Label.CENTER);
		
		JLabel lblGestionDeLocation = new JLabel("Gestion de location de véhicule");
		lblGestionDeLocation.setFont(new Font("Bitstream Charter", Font.BOLD, 35));
		lblGestionDeLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDeLocation.setBounds(0, 0, 1000, 100);
		Connection.add(lblGestionDeLocation);
		
		textField_1_1 = new JPasswordField();
		textField_1_1.setToolTipText("");
		textField_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1_1.setBounds(375, 300, 250, 40);
		Connection.add(textField_1_1);
		
		lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.RED);
		lblNewLabel_8_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_8_1.setBounds(0, 352, 1000, 30);
		Connection.add(lblNewLabel_8_1);
		
		Home = new JPanel();
		Home.setBounds(0, 100, 1000, 400);
		layeredPane.add(Home);
		Home.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter une nouvelle location de voiture");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 500, 40);
		Home.add(lblNewLabel);
		
		btnCliquerIci = new JButton("Cliquer ici");
		btnCliquerIci.setBounds(175, 70, 150, 30);
		btnCliquerIci.setName("nouvelle_location");
		Home.add(btnCliquerIci);
		
		JLabel lblAjouterUnCollaborateur = new JLabel("Ajouter un collaborateur");
		lblAjouterUnCollaborateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterUnCollaborateur.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAjouterUnCollaborateur.setBounds(0, 100, 500, 60);
		Home.add(lblAjouterUnCollaborateur);
		
		btnCliquerIci_1 = new JButton("Cliquer ici");
		btnCliquerIci_1.setName("nouveau_collaborateur");
		btnCliquerIci_1.setBounds(175, 170, 150, 30);
		Home.add(btnCliquerIci_1);
		
		JLabel lblAjouterUnParking = new JLabel("Ajouter un parking");
		lblAjouterUnParking.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterUnParking.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAjouterUnParking.setBounds(0, 213, 500, 60);
		Home.add(lblAjouterUnParking);
		
		btnCliquerIci_1_1 = new JButton("Cliquer ici");
		btnCliquerIci_1_1.setName("nouveau_parking");
		btnCliquerIci_1_1.setBounds(175, 283, 150, 30);
		Home.add(btnCliquerIci_1_1);
		
		JLabel lblToutLesCollaborateur = new JLabel("Tout les collaborateurs");
		lblToutLesCollaborateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblToutLesCollaborateur.setFont(new Font("Dialog", Font.BOLD, 20));
		lblToutLesCollaborateur.setBounds(500, 100, 500, 60);
		Home.add(lblToutLesCollaborateur);
		
		btnCliquerIci_1_1_1 = new JButton("Cliquer ici");
		btnCliquerIci_1_1_1.setName("afficher_collaborateurs");
		btnCliquerIci_1_1_1.setBounds(675, 170, 150, 30);
		Home.add(btnCliquerIci_1_1_1);
		
		JLabel lblToutLesParkings = new JLabel("Tout les parkings");
		lblToutLesParkings.setHorizontalAlignment(SwingConstants.CENTER);
		lblToutLesParkings.setFont(new Font("Dialog", Font.BOLD, 20));
		lblToutLesParkings.setBounds(500, 213, 500, 60);
		Home.add(lblToutLesParkings);
		
		btnCliquerIci_1_1_2 = new JButton("Cliquer ici");
		btnCliquerIci_1_1_2.setName("afficher_parkings");
		btnCliquerIci_1_1_2.setBounds(675, 283, 150, 30);
		Home.add(btnCliquerIci_1_1_2);
		
		lblTouteLesLocations = new JLabel("Toutes les locations");
		lblTouteLesLocations.setHorizontalAlignment(SwingConstants.CENTER);
		lblTouteLesLocations.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTouteLesLocations.setBounds(500, 10, 500, 40);
		Home.add(lblTouteLesLocations);
		
		btnCliquerIci_2 = new JButton("Cliquer ici");
		btnCliquerIci_2.setName("afficher_locations");
		btnCliquerIci_2.setBounds(675, 70, 150, 30);
		Home.add(btnCliquerIci_2);
		
		NouvelleLocation = new JPanel();
		layeredPane.add(NouvelleLocation, "name_3899574615604");
		NouvelleLocation.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Quel parking ?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 120, 500, 50);
		NouvelleLocation.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(150, 180, 200, 24);
		NouvelleLocation.add(comboBox);
		
		JLabel lblQuelle = new JLabel("Quelle véhicule ?");
		lblQuelle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblQuelle.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuelle.setBounds(500, 120, 500, 50);
		NouvelleLocation.add(lblQuelle);
		
		JLabel lblNouvelleLocation = new JLabel("Nouvelle location");
		lblNouvelleLocation.setName("retour");
		lblNouvelleLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouvelleLocation.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNouvelleLocation.setBounds(0, 26, 1000, 50);
		NouvelleLocation.add(lblNouvelleLocation);
		
		JLabel lblDateDeDbut = new JLabel("Date de début");
		lblDateDeDbut.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateDeDbut.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDateDeDbut.setBounds(0, 230, 500, 50);
		NouvelleLocation.add(lblDateDeDbut);
		
		JLabel lblDateDeFin = new JLabel("Date de fin");
		lblDateDeFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateDeFin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDateDeFin.setBounds(500, 230, 500, 50);
		NouvelleLocation.add(lblDateDeFin);
		
		btnNewButton = new JButton("Validé");
		btnNewButton.setName("validation_location");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(60, 179, 113));
		btnNewButton.setForeground(SystemColor.control);
		btnNewButton.setBounds(425, 527, 150, 40);
		NouvelleLocation.add(btnNewButton);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(650, 180, 200, 24);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Voiture", "Moto", "Velo"}));
		NouvelleLocation.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(150, 290, 200, 24);
		NouvelleLocation.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(650, 290, 200, 24);
		NouvelleLocation.add(textField_2);
		
		JLabel lblCollaborateur = new JLabel("Collaborateur");
		lblCollaborateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollaborateur.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCollaborateur.setBounds(0, 350, 1000, 50);
		NouvelleLocation.add(lblCollaborateur);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(400, 410, 200, 24);
		NouvelleLocation.add(comboBox_2);
		
		btnRetour = new JButton("Retour");
		btnRetour.setName("retour");
		btnRetour.setBackground(UIManager.getColor("Button.darkShadow"));
		btnRetour.setBounds(100, 30, 117, 25);
		NouvelleLocation.add(btnRetour);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_5.setBounds(0, 465, 1000, 30);
		NouvelleLocation.add(lblNewLabel_5);
		
		NouveauUser = new JPanel();
		layeredPane.add(NouveauUser, "name_2515492344541");
		NouveauUser.setLayout(null);
		
		JLabel lblNouveauCollaborateur = new JLabel("Nouveau collaborateur");
		lblNouveauCollaborateur.setBounds(0, 26, 1000, 50);
		lblNouveauCollaborateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouveauCollaborateur.setFont(new Font("Dialog", Font.BOLD, 30));
		NouveauUser.add(lblNouveauCollaborateur);
		
		lblNewLabel_2 = new JLabel("Nom : *");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2.setBounds(0, 120, 500, 50);
		NouveauUser.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Prenom : *");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_3.setBounds(500, 120, 500, 50);
		NouveauUser.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(150, 180, 200, 24);
		NouveauUser.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(650, 180, 200, 24);
		NouveauUser.add(textField_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mail : ( Si Administrateur )");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(0, 270, 500, 50);
		NouveauUser.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Mot de passe : ( Si Administrateur )");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(500, 270, 500, 50);
		NouveauUser.add(lblNewLabel_2_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(150, 330, 200, 24);
		NouveauUser.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(650, 330, 200, 24);
		NouveauUser.add(textField_6);
		
		btnNewButton_1 = new JButton("Validé");
		btnNewButton_1.setName("validation_user");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(60, 179, 113));
		btnNewButton_1.setBounds(425, 474, 150, 40);
		NouveauUser.add(btnNewButton_1);
		
		btnRetour_1 = new JButton("Retour");
		btnRetour_1.setName("retour");
		btnRetour_1.setBackground(UIManager.getColor("Button.darkShadow"));
		btnRetour_1.setBounds(68, 40, 117, 25);
		NouveauUser.add(btnRetour_1);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_4.setBounds(0, 422, 1000, 30);
		NouveauUser.add(lblNewLabel_4);
		
		NouveauParking = new JPanel();
		NouveauParking.setLayout(null);
		layeredPane.add(NouveauParking, "name_145182815417");
		
		lblNouveauParking = new JLabel("Nouveau parking");
		lblNouveauParking.setHorizontalAlignment(SwingConstants.CENTER);
		lblNouveauParking.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNouveauParking.setBounds(0, 26, 1000, 50);
		NouveauParking.add(lblNouveauParking);
		
		lblNewLabel_6 = new JLabel("Nombre de place pour voiture : *");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_6.setBounds(0, 120, 500, 50);
		NouveauParking.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Nombre de place pour moto : *");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_7.setBounds(500, 120, 500, 50);
		NouveauParking.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(150, 180, 200, 24);
		NouveauParking.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(650, 180, 200, 24);
		NouveauParking.add(textField_8);
		
		lblNewLabel_2_2 = new JLabel("Nombre de place pour vélo : *");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(0, 270, 500, 50);
		NouveauParking.add(lblNewLabel_2_2);
		
		lblNewLabel_2_1_2 = new JLabel("Nom du parking : *");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1_2.setBounds(500, 270, 500, 50);
		NouveauParking.add(lblNewLabel_2_1_2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(150, 330, 200, 24);
		NouveauParking.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(650, 330, 200, 24);
		NouveauParking.add(textField_10);
		
		btnNewButton_2 = new JButton("Validé");
		btnNewButton_2.setName("validation_parking");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(60, 179, 113));
		btnNewButton_2.setBounds(425, 474, 150, 40);
		NouveauParking.add(btnNewButton_2);
		
		btnRetour_2 = new JButton("Retour");
		btnRetour_2.setName("retour");
		btnRetour_2.setBackground(UIManager.getColor("Button.darkShadow"));
		btnRetour_2.setBounds(68, 40, 117, 25);
		NouveauParking.add(btnRetour_2);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_8.setBounds(0, 422, 1000, 30);
		NouveauParking.add(lblNewLabel_8);
		
		//
		
		AfficherCollaborateurs = new JPanel();
		layeredPane.add(AfficherCollaborateurs, "name_71647849530794");
		AfficherCollaborateurs.setLayout(null);
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 150, 990, 435);
		AfficherCollaborateurs.add(scrollPane);
		table.setModel(new DefaultTableModel(new Object[][] {{null, null, null}}, new String[] {"test", "test", "test"}));
		scrollPane.setViewportView(table);
		table.setBounds(50, 119, 900, 370);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 50, 990, 50);
		AfficherCollaborateurs.add(panel_1);
		
		JLabel lblCollaborateurs = new JLabel("Collaborateurs: ");
		panel_1.add(lblCollaborateurs);
		lblCollaborateurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollaborateurs.setFont(new Font("Dialog", Font.BOLD, 30));
		
		btnRetour_2_1 = new JButton("Retour");
		btnRetour_2_1.setName("retour");
		btnRetour_2_1.setBackground(UIManager.getColor("Button.darkShadow"));
		btnRetour_2_1.setBounds(12, 12, 117, 25);
		AfficherCollaborateurs.add(btnRetour_2_1);
		
		btnRetour_2_1_1 = new JButton("Supprimer");
		btnRetour_2_1_1.setName("supprimer");
		btnRetour_2_1_1.setBackground(UIManager.getColor("Button.darkShadow"));
		btnRetour_2_1_1.setBounds(416, 112, 117, 25);
		AfficherCollaborateurs.add(btnRetour_2_1_1);
		
		//
				
		AfficherParkings = new JPanel();
		layeredPane.add(AfficherParkings, "name_71647849530795");
		AfficherParkings.setLayout(null);
		table_1 = new JTable();
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(0, 150, 990, 435);
		AfficherParkings.add(scrollPane2);
		table_1.setModel(new DefaultTableModel(new Object[][] {{null, null, null}}, new String[] {"test", "test", "test"}));
		scrollPane2.setViewportView(table_1);
		table_1.setBounds(50, 119, 900, 370);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 50, 990, 50);
		AfficherParkings.add(panel_2);
		
		JLabel lblParking = new JLabel("Parkings: ");
		panel_2.add(lblParking);
		lblParking.setHorizontalAlignment(SwingConstants.CENTER);
		lblParking.setFont(new Font("Dialog", Font.BOLD, 30));
		
		btnRetour_2_2 = new JButton("Retour");
		btnRetour_2_2.setName("retour");
		btnRetour_2_2.setBackground(UIManager.getColor("Button.darkShadow"));
		btnRetour_2_2.setBounds(12, 12, 117, 25);
		AfficherParkings.add(btnRetour_2_2);
		
		//
		
		AfficherLocations = new JPanel();
		layeredPane.add(AfficherLocations, "name_71647849530796");
		AfficherLocations.setLayout(null);
		table_2 = new JTable();
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(0, 150, 990, 435);
		AfficherLocations.add(scrollPane3);
		table_2.setModel(new DefaultTableModel(new Object[][] {{null, null, null}}, new String[] {"test", "test", "test"}));
		scrollPane3.setViewportView(table_2);
		table_2.setBounds(50, 119, 900, 370);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 50, 990, 50);
		AfficherLocations.add(panel_3);
		
		JLabel lblLocations = new JLabel("Locations: ");
		panel_3.add(lblLocations);
		lblLocations.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocations.setFont(new Font("Dialog", Font.BOLD, 30));
		
		btnRetour_2_3 = new JButton("Retour");
		btnRetour_2_3.setName("retour");
		btnRetour_2_3.setBackground(UIManager.getColor("Button.darkShadow"));
		btnRetour_2_3.setBounds(12, 12, 117, 25);
		AfficherLocations.add(btnRetour_2_3);
		
		
		
	}
	public JPanel getConnection() {
		return Connection;
	}
	public JButton getButton() {
		return button;
	}
	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public JPanel getHome() {
		return Home;
	}
	public JButton getBtnCliquerIci() {
		return btnCliquerIci;
	}
	public JPanel getNouvelleLocation() {
		return NouvelleLocation;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public JComboBox getComboBox_1() {
		return comboBox_1;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public JTextField getTextField() {
		return textField;
	}
	public JTextField getTextField_2() {
		return textField_2;
	}
	public JComboBox getComboBox_2() {
		return comboBox_2;
	}
	public JButton getBtnCliquerIci_1() {
		return btnCliquerIci_1;
	}
	public JPanel getNouveauUser() {
		return NouveauUser;
	}
	public JTextField getTextField_3() {
		return textField_3;
	}
	public JTextField getTextField_4() {
		return textField_4;
	}
	public JTextField getTextField_5() {
		return textField_5;
	}
	public JTextField getTextField_6() {
		return textField_6;
	}
	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}
	public JButton getBtnRetour() {
		return btnRetour;
	}
	public JButton getBtnRetour_1() {
		return btnRetour_1;
	}
	public JButton getBtnCliquerIci_1_1() {
		return btnCliquerIci_1_1;
	}
	public JTextField getTextField_7() {
		return textField_7;
	}
	public JTextField getTextField_8() {
		return textField_8;
	}
	public JTextField getTextField_9() {
		return textField_9;
	}
	public JTextField getTextField_10() {
		return textField_10;
	}
	public JButton getBtnRetour_2() {
		return btnRetour_2;
	}
	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}
	public JPasswordField getTextField_1_1() {
		return textField_1_1;
	}
	public TextField getTextField_1() {
		return textField_1;
	}
	public JLabel getLblNewLabel_8_1() {
		return lblNewLabel_8_1;
	}
	public JButton getBtnCliquerIci_1_1_1() {
		return btnCliquerIci_1_1_1;
	}
	public JPanel getAfficherCollaborateurs() {
		return AfficherCollaborateurs;
	}
	public JButton getBtnRetour_2_1() {
		return btnRetour_2_1;
	}
	public JButton getBtnCliquerIci_1_1_2() {
		return btnCliquerIci_1_1_2;
	}
	public JButton getBtnRetour_2_2() {
		return btnRetour_2_2;
	}
	public JTable getTable_1() {
		return table_1;
	}
	public JTable getTable() {
		return table;
	}
	public JButton getBtnCliquerIci_2() {
		return btnCliquerIci_2;
	}
	public JButton getBtnRetour_2_3() {
		return btnRetour_2_3;
	}
	public JTable getTable_2() {
		return table_2;
	}
	public JButton getBtnRetour_2_1_1() {
		return btnRetour_2_1_1;
	}
}
