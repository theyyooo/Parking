package DAO;

import java.util.Date;

public class Location {
	
	int id;
	int user_id;
	int parking_id;
	Date date_debut;
	Date date_fin;
	String vehicule;
	
	public Location(int user_id, int parking_id, Date date_debut, Date date_fin, String vehicule) {
		this.user_id = user_id;
		this.parking_id = parking_id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.vehicule = vehicule;
	}

	public int getId() {
		return id;
	}

	public Location setId(int id) {
		this.id = id;
		return this;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public Location setUser_id(int user_id) {
		this.user_id = user_id;
		return this;
	}

	public int getParking_id() {
		return parking_id;
	}

	public Location setParking_id(int parking_id) {
		this.parking_id = parking_id;
		return this;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public Location setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
		return this;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public Location setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
		return this;
	}

	public String getVehicule() {
		return vehicule;
	}

	public Location setVehicule(String vehicule) {
		this.vehicule = vehicule;
		return this;
	}

}
