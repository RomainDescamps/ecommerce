CREATE TABLE Client
(
    id integer NOT NULL,
    nom varchar(100) NOT NULL,
    prenom varchar(100) NOT NULL,
    adresse varchar(100) NOT NULL,
    telephone varchar(100) DEFAULT NULL,
    email varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Product
(
    id integer NOT NULL,
    name varchar(100) NOT NULL,
    description varchar(100) NOT NULL,
    lastUpdate date NOT NULL,
    price integer DEFAULT NULL,
    category integer NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category)
);

CREATE TABLE Category
(
    id integer NOT NULL,
    name varchar(100) NOT NULL,
    PRIMARY KEY (id)
    
);