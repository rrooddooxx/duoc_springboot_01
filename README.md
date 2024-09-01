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
curl -X GET 'localhost:8080/api/v1/movies/4'  # consulta x id
```

Retorna el primer resultado que coincide con el id solicitado

### Mantenedor

Sebastián Kravetz (@rrooddooxx)
