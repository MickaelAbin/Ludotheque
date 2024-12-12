-- Suppression de la table si elle existe

DROP TABLE   detail_location;
DROP TABLE  location;
DROP TABLE  exemplaire_jeu;
DROP TABLE  jeu_genre;
DROP TABLE  genre;
DROP TABLE  jeux;
DROP TABLE  client;
DROP TABLE  utilisateur;




-- Création de la table Client
CREATE TABLE IF NOT EXISTS client (
    id_client SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    cp VARCHAR(20) NOT NULL,
    ville VARCHAR(50) NOT NULL,
    rue VARCHAR(100) NOT NULL,
    telephone_perso VARCHAR(20) NOT NULL,
    mail VARCHAR(100) NOT NULL
    );

-- Création de la table Genre
CREATE TABLE IF NOT EXISTS genre (
    id_genre SERIAL PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL
    );

-- Création de la table Jeu
CREATE TABLE IF NOT EXISTS jeux (
    id_jeu SERIAL PRIMARY KEY,
    titre VARCHAR(100) NOT NULL,
    reference INTEGER NOT NULL,
    description VARCHAR(250),
    tarif_jour DECIMAL(11,2) NOT NULL,
    age_mini INTEGER NOT NULL,
    duree INTEGER NOT NULL
    );

-- Création de la table Jeu_Genre
CREATE TABLE IF NOT EXISTS jeu_genre (
    id_jeu INTEGER NOT NULL,
    id_genre INTEGER NOT NULL,
    PRIMARY KEY (id_jeu, id_genre),
    FOREIGN KEY (id_jeu) REFERENCES jeux(id_jeu),
    FOREIGN KEY (id_genre) REFERENCES genre(id_genre)
    );

-- Création de la table Exemplaire_Jeu
CREATE TABLE IF NOT EXISTS exemplaire_jeu (
    no_exemplaire SERIAL PRIMARY KEY,
    code_barre VARCHAR(100) NOT NULL,
    louable BOOLEAN NOT NULL DEFAULT TRUE,
    id_jeu INTEGER NOT NULL,
    FOREIGN KEY (id_jeu) REFERENCES jeux(id_jeu) ON DELETE CASCADE
    );
-- Création de la table Utilisateurs
CREATE TABLE IF NOT EXISTS Utilisateur (
    id_user SERIAL PRIMARY KEY,
    mailpro VARCHAR(100) NOT NULL,
    mdp VARCHAR(250) NOT NULL DEFAULT '$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc.',
    user_role VARCHAR(250) NOT NULL DEFAULT 'UTILISATEUR');

-- Créer la table location
CREATE TABLE IF NOT EXISTS location (
    id_location SERIAL PRIMARY KEY,
    date_debut_location DATE NOT NULL,
    paye BOOLEAN NOT NULL DEFAULT FALSE,
    prix_total DECIMAL(10, 2),
    id_client INT,
    FOREIGN KEY(id_client) REFERENCES client(id_client) );

-- Créer la table detail_location
CREATE TABLE IF NOT EXISTS detail_location (
    no_ligne SERIAL PRIMARY KEY,
    date_retour DATE,
    tarif_location DECIMAL(10,2) NOT NULL,
    id_location INTEGER NOT NULL,
    FOREIGN KEY (id_location) REFERENCES location(id_location),
    no_exemplaire INTEGER NOT NULL,
    FOREIGN KEY (no_exemplaire) REFERENCES exemplaire_jeu(no_exemplaire)
    );