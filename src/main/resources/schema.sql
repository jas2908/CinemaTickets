CREATE TABLE Billett
(
    id        INTEGER AUTO_INCREMENT NOT NULL,
    kino      VARCHAR(255) NOT NULL,
    antall    INTEGER      NOT NULL,
    fornavn   VARCHAR(255) NOT NULL,
    etternavn VARCHAR(255) NOT NULL,
    telefonnr INTEGER      NOT NULL,
    epost     VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);