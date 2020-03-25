CREATE TABLE user(
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	mail varchar(50),
	mdp varchar(255),
	prenom varchar(50) NOT NULL,
	nom varchar(50) NOT NULL
);

INSERT INTO user (mail, mdp, prenom, nom) VALUES('polette.theo@hotmail.fr', '123', 'theo', 'polette');

CREATE TABLE parking(
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	place_voiture int NOT NULL,
	place_moto int NOT NULL,
	place_velo int NOT NULL,
	nom varchar(50) NOT NULL
);

INSERT INTO parking (place_voiture, place_moto, place_velo, nom) VALUES(50, 10, 20, "parking Collombe");
INSERT INTO parking (place_voiture, place_moto, place_velo, nom) VALUES(30, 20, 10, "parking Bellecour");

CREATE TABLE location(
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id int NOT NULL,
	parking_id int NOT NULL,
	date_debut DATE NOT NULL,
	date_fin DATE NOT NULL,
	vehicule varchar(50) NOT NULL
);

INSERT INTO location (user_id, parking_id, date_debut, date_fin, vehicule) VALUES(1, 1, '2020-03-15', '2020-03-20', 'voiture');

