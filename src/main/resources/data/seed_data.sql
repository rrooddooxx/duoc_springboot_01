-- CREACIÓN DE TABLAS

TRUNCATE TABLE COUNTRY;
TRUNCATE TABLE LANGUAGE;
TRUNCATE TABLE MOVIE;
TRUNCATE TABLE DIRECTOR;

-- INSERCIÓN PAÍSES

INSERT INTO
    Country (name)
VALUES
    ('USA');
INSERT INTO
    Country (name)
VALUES
    ('UK');
INSERT INTO
    Country (name)
VALUES
    ('Canada');
INSERT INTO
    Country (name)
VALUES
    ('Australia');
INSERT INTO
    Country (name)
VALUES
    ('Spain');
INSERT INTO
    Country (name)
VALUES
    ('Mexico');
INSERT INTO
    Country (name)
VALUES
    ('Italy');
INSERT INTO
    Country (name)
VALUES
    ('France');
INSERT INTO
    Country (name)
VALUES
    ('Sweden');
INSERT INTO
    Country (name)
VALUES
    ('Germany');
INSERT INTO
    Country (name)
VALUES
    ('New Zealand');
COMMIT;


-- INSERCIÓN IDIOMAS
INSERT INTO
    Language (name)
VALUES
    ('English');
INSERT INTO
    Language (name)
VALUES
    ('Spanish');
INSERT INTO
    Language (name)
VALUES
    ('Italian');
INSERT INTO
    Language (name)
VALUES
    ('Swedish');
INSERT INTO
    Language (name)
VALUES
    ('German');
COMMIT;


-- INSERCIÓN DIRECTORES, UTILIZANDO SUBCONSULTAS PARA EL PAÍS
INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'John',
    'Doe',
    country_id,
    TO_DATE('1975-06-15', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'USA';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Emma',
    'Smith',
    country_id,
    TO_DATE('1982-03-22', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'UK';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Lucas',
    'Brown',
    country_id,
    TO_DATE('1968-11-08', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'Canada';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Sophia',
    'Johnson',
    country_id,
    TO_DATE('1979-09-01', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'Australia';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Michael',
    'Lee',
    country_id,
    TO_DATE('1985-12-30', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'USA';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Olivia',
    'Martinez',
    country_id,
    TO_DATE('1990-05-14', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'Spain';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'James',
    'Garcia',
    country_id,
    TO_DATE('1972-07-19', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'Mexico';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Isabella',
    'Wilson',
    country_id,
    TO_DATE('1986-02-25', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'Italy';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Daniel',
    'Moore',
    country_id,
    TO_DATE('1980-08-12', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'USA';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Ava',
    'Taylor',
    country_id,
    TO_DATE('1975-10-05', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'France';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Ethan',
    'Anderson',
    country_id,
    TO_DATE('1983-04-21', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'Sweden';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Mia',
    'Thompson',
    country_id,
    TO_DATE('1979-01-17', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'Germany';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Jacob',
    'White',
    country_id,
    TO_DATE('1987-09-09', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'Australia';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Charlotte',
    'Harris',
    country_id,
    TO_DATE('1981-12-14', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'Canada';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Amelia',
    'Clark',
    country_id,
    TO_DATE('1988-06-03', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'New Zealand';

INSERT INTO
    DIRECTOR (first_name, last_name, country_id, birth_date, death_date)
SELECT
    'Benjamin',
    'Lewis',
    country_id,
    TO_DATE('1977-04-18', 'YYYY-MM-DD'),
    NULL
FROM
    Country
WHERE name = 'USA';
COMMIT;

-- INSERCIÓN DE PELÍCULAS

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('The Silent Echo',
     1,
     'Drama',
     2023,
     120,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'USA'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'English'),
     'PG-13');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Lost Horizons',
     2,
     'Adventure',
     2024,
     135,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'UK'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'English'),
     'R');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Whispers of the Night',
     3,
     'Thriller',
     2022,
     110,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'New Zealand'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'English'),
     'PG-13');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Echoes of the Past',
     4,
     'Historical',
     2021,
     140,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'Mexico'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'Spanish'),
     'PG');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Quantum Leap',
     5,
     'Science Fiction',
     2023,
     125,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'Italy'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'Italian'),
     'PG-13');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Underworld Secrets',
     6,
     'Horror',
     2024,
     105,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'Spain'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'Spanish'),
     'R');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('City Lights',
     7,
     'Romance',
     2023,
     115,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'Mexico'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'Spanish'),
     'PG');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('The Secret Agent',
     8,
     'Action',
     2024,
     130,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'Italy'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'Italian'),
     'PG-13');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Starlight Dreams',
     9,
     'Fantasy',
     2022,
     140,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'Sweden'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'Swedish'),
     'PG');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('The Last Frontier',
     10,
     'Western',
     2023,
     125,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'Germany'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'German'),
     'R');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Midnight Sun',
     11,
     'Romantic Comedy',
     2024,
     100,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'France'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'French'),
     'PG');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Hidden Truths',
     12,
     'Mystery',
     2023,
     110,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'UK'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'English'),
     'PG-13');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Celestial Odyssey',
     13,
     'Science Fiction',
     2022,
     140,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'New Zealand'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'English'),
     'PG-13');

INSERT INTO
    MOVIE (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('The Dream Weaver',
     14,
     'Drama',
     2024,
     120,
     (SELECT COUNTRY_ID FROM COUNTRY WHERE NAME = 'Mexico'),
     (SELECT LANG_ID FROM LANGUAGE WHERE NAME = 'Spanish'),
     'PG');
COMMIT;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'En un mundo donde el silencio habla más fuerte que las palabras, "El Eco Silencioso" narra la historia de un joven protagonista que descubre verdades ocultas en una ciudad moderna, desafiando las normas sociales.'
WHERE MOVIE_ID = 1;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'A través de territorios inexplorados, "Horizontes Perdidos" sigue a un grupo de exploradores que se topan con secretos antiguos que podrían cambiar el destino de la humanidad.'
WHERE MOVIE_ID = 2;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'Un relato escalofriante de suspenso, "Susurros de la Noche" explora los oscuros callejones de una ciudad donde cada esquina esconde un nuevo secreto, y no todos son de fiar.'
WHERE MOVIE_ID = 3;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'Ambientada en el marco de una época pasada, "Ecos del Pasado" revela una historia de amor oculta entrelazada con intrigas políticas que moldearon el curso de la historia.'
WHERE MOVIE_ID = 4;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'En el año 2023, los avances científicos llevan a consecuencias inesperadas en "Salto Cuántico", donde el tiempo y la realidad se confunden, haciendo de la supervivencia el reto supremo.'
WHERE MOVIE_ID = 5;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'Bajo la superficie de un pueblo tranquilo se esconde un oscuro secreto, y en "Secretos del Inframundo", males antiguos resurgen, amenazando con consumirlo todo a su paso.'
WHERE MOVIE_ID = 6;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'En medio de calles bulliciosas, "Luces de Ciudad" despliega un conmovedor romance donde dos almas se encuentran contra todo pronóstico, demostrando que el amor brilla con más intensidad en los tiempos más oscuros.'
WHERE MOVIE_ID = 7;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'Una misión de alto riesgo en "El Agente Secreto" toma giros inesperados mientras las alianzas se ponen a prueba y la línea entre amigo y enemigo se vuelve peligrosamente delgada.'
WHERE MOVIE_ID = 8;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'En un reino donde los sueños son reales, "Sueños de Luz de Estrellas" lleva a los espectadores en un viaje mágico donde una joven ordinaria descubre su destino extraordinario.'
WHERE MOVIE_ID = 9;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'El Lejano Oeste se reinventa en "La Última Frontera", una historia de supervivencia, lealtad y el espíritu indomable de los pioneros que desafían los elementos más duros para construir una nueva vida.'
WHERE MOVIE_ID = 10;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'En un mundo que nunca duerme, "Sol de Medianoche" mezcla humor y romance mientras una joven pareja navega por las complejidades del amor y la vida bajo las brillantes luces de la ciudad.'
WHERE MOVIE_ID = 11;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'Descubriendo una serie de misterios enterrados hace mucho tiempo, "Verdades Ocultas" sigue a una detective decidida cuya búsqueda de la verdad lleva a revelaciones inesperadas sobre su propio pasado.'
WHERE MOVIE_ID = 12;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'En un futuro cercano, "Odisea Celestial" narra la lucha épica de la humanidad para sobrevivir y prosperar en el vasto y desconocido universo, desafiando los límites de la ciencia y la imaginación.'
WHERE MOVIE_ID = 13;

UPDATE SPRINGBOOT01_MATRIX.MOVIE
SET
    SYNOPSIS = 'En "El Tejedor de Sueños", un joven visionario descubre el poder de influir en los sueños de otros, desatando un torbellino de emociones y revelaciones en un mundo que necesita esperanza.'
WHERE MOVIE_ID = 14;
COMMIT;
