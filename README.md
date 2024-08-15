# API REST con Spring Boot

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

### Endpoints:

> Base Host: localhost:8080

#### Obtener todas las películas

> Retorna el listado completo de películas ó filtra por un límite de resultados

`[GET] /api/v1/movies`

- Query Params:
    - _opcional_ limit: int
        - ej: `/api/v1/movies?limit=5`

- Ejemplo Response `curl /api/v1/movies`:
    - ![all_movies.png](src/static/all_movies.png)
- Ejemplo Response `curl /api/v1/movies?limit=1`:
    - ![movies_filtered.png](src/static/movies_filtered.png)

#### Obtener película por ID

`[GET] /api/v1/movies/{id}`

- Ejemplo Response `curl api/v1/movies/16`
    - ![movie_by_id.png](src/static/movie_by_id.png)

### Mantenedor

Sebastián Kravetz (@rrooddooxx)
