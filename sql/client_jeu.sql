-- Suppression de la table si elle existe déjà
-- DROP TABLE IF EXISTS client;
-- DROP TABLE IF EXISTS jeux;

-- Création de la base de données n'est pas nécessaire dans PostgreSQL
-- Les bases de données sont généralement créées séparément

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
CREATE TABLE jeu_genre (
    id_jeu INTEGER NOT NULL,
    id_genre INTEGER NOT NULL,
    PRIMARY KEY (id_jeu, id_genre),
    FOREIGN KEY (id_jeu) REFERENCES jeux(id_jeu),
    FOREIGN KEY (id_genre) REFERENCES genre(id_genre)
);
CREATE TABLE IF NOT EXISTS genre (
    id_genre SERIAL PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL
);
