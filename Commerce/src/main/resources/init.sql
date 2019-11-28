CREATE TABLE Client
(
    id int(11) NOT NULL AUTO_INCREMENT,
    nom varchar(100) NOT NULL,
    prenom varchar(100) NOT NULL,
    adresse varchar(100) NOT NULL,
    telephone varchar(100) DEFAULT NULL,
    email varchar(100) NOT NULL,
    PRIMARY KEY (id)
);