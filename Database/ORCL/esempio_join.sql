CREATE TABLE REPARTO (
    ID_REP INT,
    NOME_REP VARCHAR2(30),
    CONSTRAINT P_ID_REP PRIMARY KEY(ID_REP)
);

CREATE TABLE IMPIEGATO(
    ID_IMP INT,
    NOME_IMP VARCHAR2(30),
    STIPENDIO NUMBER(7, 2),
    ID_REP INT,
    CONSTRAINT P_ID_IMP PRIMARY KEY(ID_IMP),
    CONSTRAINT F_ID_REP FOREIGN KEY(ID_REP) REFERENCES REPARTO(ID_REP)
);

INSERT INTO REPARTO VALUES(
    1,
    'Analisi'
);

INSERT INTO REPARTO VALUES(
    2,
    'Vendite'
);

INSERT INTO REPARTO VALUES(
    3,
    'Imballaggio'
);

INSERT INTO REPARTO VALUES(
    4,
    'Spedizione'
);

INSERT INTO IMPIEGATO VALUES(
    1,
    'Massimo',
    2000,
    1
);

INSERT INTO IMPIEGATO VALUES(
    2,
    'Matteo',
    2000,
    2
);

INSERT INTO IMPIEGATO VALUES(
    3,
    'Anna',
    1400,
    1
);

-- inner join
select nome_imp, NOME_REP
from IMPIEGATO, REPARTO
WHERE
impiegato.id_rep = reparto.id_rep;

-- inner join
select nome_imp, NOME_REP
from impiegato
join reparto on impiegato.id_rep = reparto.id_rep;

-- inner join
select nome_imp, NOME_REP
from impiegato
inner join reparto on impiegato.id_rep = reparto.id_rep;

-- inner join
select nome_imp, NOME_REP
from impiegato
join reparto using (id_rep);

-- right (natural) join
select nome_imp, NOME_REP
from impiegato
natural right join reparto;

-- right (natural) join
select nome_imp, NOME_REP
from reparto
natural right join impiegato;

-- left (natural) join
select nome_imp, NOME_REP
from reparto
natural left join impiegato;

-- left (natural) join
select nome_imp, NOME_REP
from impiegato
natural left join reparto;

-- outer right (+)= joint
select nome_imp, NOME_REP
from impiegato, reparto
where impiegato.id_rep (+)= reparto.id_rep;

select 'il libro '||titolo||' è il '||level||' della serie '||serie as "Gerarchia libri"
 from catalogo
start with parent_isbn is null
connect by prior isbn = parent_isbn;