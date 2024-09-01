-- CREACIÓN DE TABLAS

CREATE TABLE MOVIES
(
    movie_id    NUMBER GENERATED ALWAYS AS IDENTITY NOT NULL,
    title       VARCHAR2(255)                       NOT NULL,
    director_id NUMBER                              NOT NULL,
    genre       VARCHAR2(255)                       NOT NULL,
    year        NUMBER                              NOT NULL,
    duration    NUMBER                              NOT NULL,
    country_id  NUMBER                              NOT NULL,
    language_id NUMBER                              NOT NULL,
    rating      VARCHAR(255)                        NOT NULL,
    CONSTRAINT pk_movie_id
        PRIMARY KEY (movie_id),
    CONSTRAINT fk_movie_director_id
        FOREIGN KEY (director_id)
            REFERENCES DIRECTOR (director_id),
    CONSTRAINT fk_movie_country_id
        FOREIGN KEY (country_id)
            REFERENCES COUNTRIES (country_id),
    CONSTRAINT fk_movie_language_id
        FOREIGN KEY (language_id)
            REFERENCES LANGUAGES (lang_id)
);

CREATE TABLE DIRECTOR
(
    director_id NUMBER GENERATED ALWAYS AS IDENTITY NOT NULL,
    first_name  VARCHAR2(255)                       NOT NULL,
    last_name   VARCHAR2(255)                       NOT NULL,
    country_id  NUMBER                              NOT NULL,
    CONSTRAINT pk_director_id
        PRIMARY KEY (director_id),
    CONSTRAINT fk_country_id
        FOREIGN KEY (country_id)
            REFERENCES COUNTRIES (country_id)
);

CREATE TABLE COUNTRIES
(
    country_id NUMBER GENERATED ALWAYS AS IDENTITY
        PRIMARY KEY,
    name       VARCHAR2(255) NOT NULL
);



CREATE TABLE LANGUAGES
(
    lang_id NUMBER GENERATED ALWAYS AS IDENTITY
        PRIMARY KEY,
    name    VARCHAR2(255) NOT NULL
);


-- INSERCIÓN PAÍSES

INSERT INTO
    COUNTRIES (name)
VALUES
    ('USA');
INSERT INTO
    COUNTRIES (name)
VALUES
    ('UK');
INSERT INTO
    COUNTRIES (name)
VALUES
    ('Canada');
INSERT INTO
    COUNTRIES (name)
VALUES
    ('Australia');
INSERT INTO
    COUNTRIES (name)
VALUES
    ('Spain');
INSERT INTO
    COUNTRIES (name)
VALUES
    ('Mexico');
INSERT INTO
    COUNTRIES (name)
VALUES
    ('Italy');
INSERT INTO
    COUNTRIES (name)
VALUES
    ('France');
INSERT INTO
    COUNTRIES (name)
VALUES
    ('Sweden');
INSERT INTO
    COUNTRIES (name)
VALUES
    ('Germany');
INSERT INTO
    COUNTRIES (name)
VALUES
    ('New Zealand');


-- INSERCIÓN IDIOMAS
INSERT INTO
    LANGUAGES (name)
VALUES
    ('English');
INSERT INTO
    LANGUAGES (name)
VALUES
    ('Spanish');
INSERT INTO
    LANGUAGES (name)
VALUES
    ('Italian');
INSERT INTO
    LANGUAGES (name)
VALUES
    ('Swedish');
INSERT INTO
    LANGUAGES (name)
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
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
    COUNTRIES
WHERE name = 'USA';


-- INSERCIÓN DE PELÍCULAS

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('The Silent Echo', 17, 'Drama', 2023, 120, 2, 11, 'PG-13');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Lost Horizons', 18, 'Adventure', 2024, 135, 3, 11, 'R');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Whispers of the Night', 19, 'Thriller', 2022, 110, 4, 11, 'PG-13');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Echoes of the Past', 20, 'Historical', 2021, 140, 5, 11, 'PG');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Quantum Leap', 21, 'Science Fiction', 2023, 125, 2, 11, 'PG-13');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Underworld Secrets', 22, 'Horror', 2024, 105, 6, 12, 'R');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('City Lights', 23, 'Romance', 2023, 115, 7, 12, 'PG');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('The Secret Agent', 24, 'Action', 2024, 130, 8, 13, 'PG-13');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Starlight Dreams', 25, 'Fantasy', 2022, 140, 2, 11, 'PG');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('The Last Frontier', 26, 'Western', 2023, 125, 9, 16, 'R');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Midnight Sun', 27, 'Romantic Comedy', 2024, 100, 10, 14, 'PG');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Hidden Truths', 28, 'Mystery', 2023, 110, 11, 15, 'PG-13');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('Celestial Odyssey', 29, 'Science Fiction', 2022, 140, 5, 11, 'PG-13');

INSERT INTO
    MOVIES (title, director_id, genre, year, duration, country_id, language_id, rating)
VALUES
    ('The Dream Weaver', 30, 'Drama', 2024, 120, 4, 11, 'PG');
COMMIT;
