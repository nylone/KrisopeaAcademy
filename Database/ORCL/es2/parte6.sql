/*
Clienti:=<Cod_cli,Cognome, Nome, Citta, Salario, Eta>
Prenot:=<Cod_cli, Cod_alb, Camera, Giorni, Acconto >
Alberghi:=<Cod_alb, Nome, Citta >
*/
-- 1
SELECT
    *
FROM
    CLIENTI
WHERE
    ETA = (
        SELECT
            MIN(ETA)
        FROM
            CLIENTI
    );

-- 2
SELECT
    *
FROM
    CLIENTI
WHERE
    SALARIO > (
        SELECT
            AVG(SALARIO)
        FROM
            CLIENTI
    );

-- 3
SELECT
    COGNOME,
    NOME,
    SALARIO
FROM
    CLIENTI
WHERE
    CITTA IN (
        SELECT
            CITTA
        FROM
            CLIENTI
        GROUP BY
            CITTA
        HAVING
            COUNT(*) > 1
    );

-- 4
SELECT
    *
FROM
    CLIENTI
WHERE
    CITTA IN (
        SELECT
            CITTA
        FROM
            CLIENTI
        GROUP BY
            CITTA
        HAVING
            AVG(ETA) < (
                SELECT
                    AVG(ETA)
                FROM
                    CLIENTI
            )
    );

-- 5
SELECT
    *
FROM
    CLIENTI
WHERE
    ETA > 30
    AND COD_CLI IN (
        SELECT
            COD_CLI
        FROM
            PRENOT
        WHERE
            CAMERA IN (25, 18)
    );

-- 6
SELECT
    *
FROM
    CLIENTI
WHERE
    COD_CLI IN (
        SELECT
            COD_CLI
        FROM
            PRENOT
        WHERE
            ACCONTO > (
                SELECT
                    AVG(ACCONTO)
                FROM
                    PRENOT
            )
    );