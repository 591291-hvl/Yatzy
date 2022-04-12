DROP SCHEMA IF EXISTS yatzy CASCADE;
CREATE SCHEMA yatzy;
SET search_path = yatzy;

CREATE TABLE spiller
(
    brukernavn VARCHAR(20),
    navn VARCHAR(50),
    epost VARCHAR(50),
    pwd_hash VARCHAR,
    pwd_salt VARCHAR,
   PRIMARY KEY (brukernavn)
);

CREATE TABLE yatzy
(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    antall INTEGER,
    aktiv INTEGER,
    runde INTEGER,
    playerTurn INTEGER,
    turnsPlayed INTEGER,
    brett VARCHAR,
    terninger VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE spilldeltagelse
(
    id INTEGER,
    brukernavn VARCHAR(20),
    PRIMARY KEY (id, brukernavn),
    FOREIGN KEY (id) REFERENCES yatzy(id),
    FOREIGN KEY (brukernavn) REFERENCES spiller (brukernavn)
);

INSERT INTO spiller VALUES
(
    'Dpshark',
    'Daniel',
    'Test@gmail.com',
    'FBEAD197F4B938CDD4F072C0256186606F02778459DF74A26B87A7F3AAD3548C',
    'A54AC2BB91A77759B85E0DD858AC14CA'
);

INSERT INTO spiller VALUES
(
    'Testt',
    'Test',
    'Test@gmail.com',
    '13793FAB9961823134C426613E12FFD868224A38E010AE2AF873097E2D78AC60',
    'D538A919D71A2D03082EC456E4CBADDE'
);

