-- 1
SELECT
    CLIENTI.*
FROM
    CLIENTI
    NATURAL JOIN PRENOT
WHERE
    CAMERA = 25;

-- 2
SELECT
    *
FROM
    CLIENTI
    NATURAL JOIN PRENOT
WHERE
    ETA BETWEEN 25 AND 40;

-- 3
SELECT
    PRENOT.*
FROM
    PRENOT
    NATURAL JOIN CLIENTI
WHERE
    CITTA = 'milano';

-- 4
SELECT
    COGNOME,
    NOME,
    ACCONTO,
    CAMERA
FROM
    CLIENTI
    JOIN PRENOT
    USING (COD_CLI)
WHERE
    ACCONTO > 100000
    AND ETA > 25;

-- 5
SELECT
    ALBERGHI.NOME,
    CLIENTI.NOME,
    CLIENTI.COGNOME,
    CLIENTI.CITTA
FROM
    CLIENTI
    NATURAL JOIN PRENOT AS PRENOTAZIONE
    NATURAL JOIN ALBERGHI
WHERE
    ACCONTO > (
        SELECT
            AVG(ACCONTO)
        FROM
            PRENOT
    )
GROUP BY
    ALBERGHI.COD_ALB;

-- 6
SELECT
    ALBERGHI.NOME,
    CLIENTI.NOME,
    CLIENTI.COGNOME,
    CLIENTI.CITTA
FROM
    CLIENTI
    NATURAL JOIN PRENOT AS PRENOTAZIONE
    NATURAL JOIN ALBERGHI
WHERE
    ACCONTO > (
        SELECT
            AVG(ACCONTO)
        FROM
            PRENOT AS INNER_PRENOT
        WHERE
            INNER_PRENOT.COD_ALB = PRENOTAZIONE.COD_ALB
    )
GROUP BY
    ALBERGHI.COD_ALB;

-- 7
CREATE VIEW CLIENTI_VALIDI AS
    SELECT
        CLIENTI.*
    FROM
        CLIENTI
        NATURAL JOIN PRENOT
        NATURAL JOIN ALBERGHI;

CREATE VIEW CLIENTI_FACOLTOSI AS
    SELECT
        *
    FROM
        CLIENTI_VALIDI C
    WHERE
        SALARIO > (
            SELECT
                AVG(SALARIO)
            FROM
                CLIENTI_VALIDI
            WHERE
                CITTA = C.CITTA
        );

CREATE VIEW PRENOTAZIONI_LUNGHE AS
    SELECT
        *
    FROM
        PRENOT
    WHERE
        COD_CLI IS NOT NULL
        AND COD_ALB IS NOT NULL
        AND GIORNI > (
            SELECT
                AVG(GIORNI)
            FROM
                PRENOT P
            WHERE
                P.COD_ALB = DOC_ALB
        );

SELECT
    C.NOME,
    C.COGNOME,
    C.CITTA   AS RESIDENZA,
    A.NOME    AS ALBERGO,
    A.CITTA   AS LOCALITA
FROM
    CLIENTI_FACOLTOSI   C
    NATURAL JOIN PRENOTAZIONI_LUNGHE
    NATURAL JOIN ALBERGHI A;