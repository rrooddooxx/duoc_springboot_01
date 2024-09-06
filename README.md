# Movies MS, con Spring Boot

Proyecto de Asignatura

```
Desarrollo Full Stack I
Ingeniería en Desarrollo de Software
Duoc UC

Profesor: Carlos Valverde
Estudiante: Sebastián Kravetz

```

### Stack

- Spring Boot v3
- Spring Boot Web Starter
- Lombok
- JDK 22

---

### Endpoints:

> Base Host: [DIRECCION_IP]:8080/api/v1

#### I. Obtener todas las películas

Retorna el listado completo de películas ó filtra por un límite de resultados

`[GET] /api/v1/movies`

```bash
# Peticiones cURL
curl -X GET 'localhost:8080/api/v1/movies' # listar todas las películas
```

#### I.B Filtrar por paginación por Query Params

- Query Params:
    - _opcional_ limit: int
    - _opcional_ offset: int
        - ej: `/api/v1/movies?limit=5&offset=5`

```bash
# Peticiones cURL
curl -X GET 'localhost:8080/api/v1/movies?limit=4&offset=4' # consulta con paginación
```

#### II. Obtener película por ID

`[GET] /api/v1/movies/{id}`

```bash
# Peticiones cURL
curl -X GET 'localhost:8080/api/v1/movies/4'  # en donde 4 es el ID
```

#### III. Crear Nueva Película

`[POST] /api/v1/movies`

```bash
# Peticiones cURL
curl --location 'http://localhost:8080/api/v1/movies' \
--header 'Content-Type: application/json' \
--data '{
  "title": "Inception",
  "directorId": 2,
  "genre": "Science Fiction",
  "year": 2010,
  "duration": 148,
  "countryId": 2,
  "languageId": 3,
  "rating": "PG-13",
  "synopsis": "A skilled thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O."
}
'
```

Crea una nueva película en el sistema.

#### IV. Borrar Película por ID

`[DELETE] /api/v1/movies/{id}`

```bash
# Peticiones cURL
curl --location --request DELETE 'http://localhost:8080/api/v1/movies/25' # en donde 25 es el ID
```

**Retorna 200 (OK)** si se ha borrado una película exitosamente.

**Retorna 400 (Bad Request)** si no se ha encontrado una película con ese ID.

**Retorna 500 (Internal Server Error)** si ha existido un problema técnico con el procesamiento de
la
transacción.

### Mantenedor

Sebastián Kravetz (@rrooddooxx)
