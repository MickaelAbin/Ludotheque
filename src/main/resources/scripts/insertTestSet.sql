INSERT INTO client (nom, prenom, cp, ville, rue, telephone_perso, mail)
VALUES
    ('Dupont', 'Jean', '75001', 'Paris', '1 Rue de la Paix', '0102030405', 'jean.dupont@example.com'),
    ('Martin', 'Marie', '69002', 'Lyon', '10 Rue de la République', '0607080910', 'marie.martin@example.com'),
    ('Durand', 'Paul', '33000', 'Bordeaux', '5 Allée de Tourny', '0506070809', 'paul.durand@example.com');


INSERT INTO jeux (titre, reference, description, tarif_jour, age_mini, duree)
VALUES
    ('Pandemic', 12345, 'Jeu de stratégie coopératif pour sauver le monde des pandémies.', 25.99, 8, 60),
    ('Catan', 23456, 'Jeu de société de construction et de stratégie.', 29.99, 10, 90),
    ('Carcassonne', 34567, 'Jeu de tuiles où les joueurs construisent une ville médiévale.', 20.00, 7, 45),
    ('Terraforming Mars', 45678, 'Jeu de stratégie sur la colonisation et la transformation de Mars.', 39.99, 12, 120),
    ('Azul', 56789, 'Jeu de tuiles sur la création de mosaïques portugaises.', 19.99, 8, 45);

INSERT INTO genre (libelle)
VALUES
    ('Stratégie'),
    ('Aventure'),
    ('Familial'),
    ('Coopératif'),
    ('Jeu de tuiles');

INSERT INTO jeu_genre (id_jeu, id_genre)
VALUES
    (1, 1),
    (1, 4), -- Pandemic est de genre Stratégie et Coopératif
    (2, 1),
    (2, 3), -- Catan est de genre Stratégie et Familial
    (3, 3),
    (3, 5), -- Carcassonne est de genre Familial et Jeu de tuiles
    (4, 1),
    (4, 2), -- Terraforming Mars est de genre Stratégie et Aventure
    (5, 3),
    (5, 5); -- Azul est de genre Familial et Jeu de tuiles


