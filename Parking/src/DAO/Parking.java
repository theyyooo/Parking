package DAO;

public class Parking {
	
	int id;
	int place_voiture;
	int place_moto;
	int place_velo;
	String name;
	
	public Parking(int place_voiture, int place_moto, int place_velo, String name) {
		
		this.place_voiture = place_voiture;
		this.place_moto = place_moto;
		this.place_velo = place_velo;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public Parking setName(String name) {
		this.name = name;
		return this;
	}

	public Parking() {
		
	}

	public int getId() {
		return id;
	}

	public Parking setId(int id) {
		this.id = id;
		return this;
	}

	public int getPlace_voiture() {
		return place_voiture;
	}

	public Parking setPlace_voiture(int place_voiture) {
		this.place_voiture = place_voiture;
		return this;
	}

	public int getPlace_moto() {
		return place_moto;
	}

	public Parking setPlace_moto(int place_moto) {
		this.place_moto = place_moto;
		return this;
	}

	public int getPlace_velo() {
		return place_velo;
	}

	public Parking setPlace_velo(int place_velo) {
		this.place_velo = place_velo;
		return this;
	}

}
