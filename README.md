# Movies Play

Este proyecto es una aplicación de microservicios desarrollada con Spring Boot para gestionar información sobre películas. La aplicación expone una API RESTful para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) y, de manera innovadora, utiliza la librería LangChain4j para integrar inteligencia artificial y generar sugerencias de películas basadas en preferencias del usuario.

## Características Principales

- **API RESTful**: Endpoints bien definidos para gestionar películas
- **Spring Boot 3.5.4**: Un framework robusto y de alto rendimiento
- **Java 21**: Utiliza la última versión LTS (Long-Term Support) de Java
- **Gradle**: Administrador de dependencias y herramienta de construcción del proyecto
- **Spring Data JPA**: Para la persistencia de datos
- **PostgreSQL**: Base de datos relacional utilizada en el proyecto
- **MapStruct**: Herramienta de mapeo de objetos para convertir entre DTOs y entidades de forma eficiente
- **LangChain4j**: Integración con modelos de lenguaje de OpenAI (como gpt-4o-mini) para generar sugerencias de películas
- **OpenAPI**: Documentación automática de la API con Swagger UI
- **Docker**: Soporte para la construcción y despliegue en contenedores, utilizando una configuración de varias etapas para optimizar el tamaño de la imagen

## Arquitectura del Proyecto

El proyecto sigue una arquitectura por capas, con una estructura de paquetes clara:

- `com.movies_play.web.controller`: Contiene los controladores REST (MovieController, HelloController)
- `com.movies_play.domain.service`: Implementa la lógica de negocio (MovieService, MoviesPlayService)
- `com.movies_play.domain.dto`: Define los DTOs para la transferencia de datos (MovieDto, SuggestRequestDto, etc.)
- `com.movies_play.persistence`: Gestiona la capa de persistencia, incluyendo el repositorio de Spring Data JPA y los mappers (MovieMapper, GenreMapper)
- `com.movies_play.persistence.entity`: Define las entidades de la base de datos (MovieEntity)

## Cómo Empezar

### Requisitos Previos

- JDK 21
- Gradle
- Docker
- Una instancia de PostgreSQL

### Configuración de la Base de Datos

El proyecto incluye archivos de configuración para diferentes entornos:

- `application-dev.properties`: Conexión a una base de datos local en localhost:5432 con usuario fernando
- `application-prod.properties`: Configuración para un entorno de producción, con una URL de base de datos externa

Además, el archivo `data.sql` se ejecuta automáticamente para inicializar la base de datos con películas de ejemplo.

### Compilación y Ejecución

Para construir el proyecto, ejecuta el siguiente comando con Gradle:

```bash
./gradlew build
```

Una vez construido, puedes ejecutar la aplicación directamente desde el JAR generado o a través de Docker.

### Ejecución con Docker

El proyecto está configurado para ser ejecutado en un contenedor de Docker.

1. **Construir la imagen de Docker**:
   ```bash
   docker build -t movies_play .
   ```

2. **Ejecutar el contenedor**:
   ```bash
   docker run -p 8080:8080 movies_play
   ```

La aplicación estará disponible en [http://localhost:8080](http://localhost:8080).

## Endpoints de la API

La API se encuentra en la ruta `/movies-play/api` y la documentación de Swagger se puede acceder en [http://localhost:8080/movies-play/api/swagger-ui.html](http://localhost:8080/movies-play/api/swagger-ui.html).

Aquí están algunos de los endpoints principales:

- `GET /movies-play/api/movies`: Obtiene una lista de todas las películas
- `GET /movies-play/api/movies/{id}`: Obtiene una película por su ID
- `POST /movies-play/api/movies`: Agrega una nueva película
- `PUT /movies-play/api/movies/{id}`: Actualiza una película existente
- `DELETE /movies-play/api/movies/{id}`: Elimina una película por su ID
- `POST /movies-play/api/movies/suggest`: Genera sugerencias de películas usando la IA, basándose en preferencias de usuario

## Contribuciones

Siéntete libre de contribuir a este proyecto. Para ello, por favor crea un fork del repositorio y envía un Pull Request con tus cambios.
