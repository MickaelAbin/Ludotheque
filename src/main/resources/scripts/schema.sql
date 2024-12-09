-- Suppression de la table si elle existe
DROP TABLE IF EXISTS exemplaire_jeu;
DROP TABLE IF EXISTS jeu_genre;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS jeux;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS utilisateur;




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

-- Création de la table Jeux
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
    user_role VARCHAR(250) NOT NULL DEFAULT 'USER');