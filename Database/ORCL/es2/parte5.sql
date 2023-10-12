-- 1
SELECT
    CITTA,
    AVG(ETA)
FROM
    CLIENTI
GROUP BY
    CITTA
HAVING
    AVG(ETA) > 30;

-- 2
SELECT
    CITTA,
    MAX(SALARIO)
FROM
    CLIENTI
GROUP BY
    CITTA
HAVING
    AVG(ETA) < 35;

-- 3
SELECT
    CITTA,
    AVG(SALARIO),
    AVG(ETA),
    COUNT(*)
FROM
    CLIENTI
WHERE
    ETA BETWEEN 20 AND 40
GROUP BY
    CITTA
HAVING
    COUNT(*) > 1;