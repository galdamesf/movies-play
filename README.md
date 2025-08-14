# 🎥 Movies Play

🎬 **Aplicación de Gestión de Películas • IA y Persistencia** 🎬

```
     🍿  M O V I E S P L A Y  🍿
 ╭─────────────────────────────╮
 │ 🤖Plataforma de Películas 🤖 │
 │    🎬 IA y API RESTful 🎬    │
 ╰─────────────────────────────╯
```

⭐ **Una plataforma innovadora para gestionar y sugerir películas utilizando inteligencia artificial** ⭐

## 📋 Tabla de Contenidos

- [🌍 Acerca del Proyecto](#-acerca-del-proyecto)
- [✨ Características Principales](#-características-principales)
- [🚀 Demo en Vivo](#-demo-en-vivo)
- [⚡️ Tecnologías](#️-tecnologías)
- [📦 Instalación](#-instalación)
- [⚙️ Configuración](#️-configuración)
- [🎮 Uso](#-uso)
- [📡 API Documentation](#-api-documentation)
- [📁 Estructura del Proyecto](#-estructura-del-proyecto)
- [🗺️ Roadmap](#️-roadmap)
- [🤝 Contribuir](#-contribuir)
- [📄 Licencia](#-licencia)
- [📞 Contacto](#-contacto)
- [🙏 Agradecimientos](#-agradecimientos)

## 🌍 Acerca del Proyecto

**movies-play** es una aplicación de microservicios desarrollada con Spring Boot para gestionar información sobre películas. El proyecto expone una API RESTful que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre un catálogo de películas. Además, integra la librería LangChain4j para aprovechar modelos de lenguaje y generar sugerencias personalizadas de películas.

### 🎯 Objetivos

El proyecto fue diseñado para crear una plataforma robusta y escalable que combine:

- Gestión de datos de películas a través de una API REST
- Inteligencia artificial para ofrecer recomendaciones dinámicas
- Persistencia de datos eficiente con Spring Data JPA y PostgreSQL
- Despliegue sencillo en contenedores con Docker

## ✨ Características Principales

| Característica | Descripción | Estado |
|---|---|---|
| **API RESTful** | Endpoints bien definidos para operaciones CRUD | ✅ |
| **Integración con IA** | Genera sugerencias de películas con LangChain4j y el modelo gpt-4o-mini | ✅ |
| **Persistencia con JPA** | Usa Spring Data JPA y un repositorio para gestionar los datos | ✅ |
| **Base de Datos PostgreSQL** | El proyecto está configurado para usar PostgreSQL | ✅ |
| **Mapeo de Objetos** | Usa MapStruct para convertir entre DTOs y entidades de forma eficiente | ✅ |
| **Documentación Automática** | Genera la documentación de la API con OpenAPI y Swagger UI | ✅ |
| **Soporte para Docker** | Un Dockerfile con un enfoque de varias etapas para crear imágenes optimizadas | ✅ |

## 🚀 Demo en Vivo

Explora todas las funcionalidades de la API en el entorno de despliegue:

- 🔗 **Demo de la API**: [https://moviesplay.onrender.com/movies-play/api/movies](https://moviesplay.onrender.com/movies-play/api/movies)
- 🔗 **Documentación OpenAPI (Swagger)**: [https://moviesplay.onrender.com/movies-play/api/swagger-ui.html](https://moviesplay.onrender.com/movies-play/api/swagger-ui.html)

## ⚡️ Tecnologías

### Backend
- **Spring Boot** 3.5.4
- **Java** 21
- **Gradle**
- **PostgreSQL**
- **Spring Data JPA**
- **LangChain4j** (dev.langchain4j-open-ai-spring-boot-starter)
- **MapStruct** (org.mapstruct:mapstruct)

### DevOps & Herramientas
- **Docker**
- **Springdoc-Openapi**
- **Lombok**
- **Hibernate Validator** (spring-boot-starter-validation)

## 📦 Instalación

### Prerrequisitos
Asegúrate de tener instalado:

- **JDK 21**
- **Gradle** (el proyecto incluye el wrapper)
- **Docker**
- **PostgreSQL**

### Instalación Rápida

```bash
# 1. Clonar el repositorio
git clone https://github.com/galdamesf/movies-play.git
cd movies-play

# 2. Compilar el proyecto
./gradlew build
```

## ⚙️ Configuración

### Variables de Entorno

El proyecto utiliza perfiles de Spring para la configuración de diferentes entornos:

- **application.properties**: Define el perfil activo (`spring.profiles.active=dev`) y la ruta de la API (`/movies-play/api`)
- **application-dev.properties**: Configuración para desarrollo, con conexión a una base de datos local y el puerto 8090
- **application-prod.properties**: Configuración para producción, con conexión a una base de datos externa y el puerto 8080

### Base de Datos

Los archivos `data.sql` y `schema.sql` se ejecutan automáticamente para inicializar la base de datos con tablas y datos de ejemplo al arrancar la aplicación.

## 🎮 Uso

### Desarrollo

Ejecuta la aplicación con Gradle, que usará la configuración de `application-dev.properties`:

```bash
# Ejecutar la aplicación en modo de desarrollo
./gradlew bootRun
```

La aplicación estará disponible en [http://localhost:8090/movies-play/api](http://localhost:8090/movies-play/api).

### Docker

El Dockerfile utiliza un build multi-stage para crear una imagen optimizada:

```bash
# 1. Construir la imagen de Docker
docker build -t movies_play .

# 2. Ejecutar el contenedor con el perfil de producción
docker run -p 8080:8080 -e spring.profiles.active=prod movies_play
```

La aplicación estará disponible en [http://localhost:8080/movies-play/api](http://localhost:8080/movies-play/api).

## 📡 API Documentation

La documentación de la API se genera automáticamente con OpenAPI y Swagger UI.

**URL de la documentación**: [http://localhost:8080/movies-play/api/swagger-ui.html](http://localhost:8080/movies-play/api/swagger-ui.html)

### Endpoints Principales

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/movies` | Obtiene una lista de todas las películas |
| `GET` | `/api/movies/{id}` | Obtiene una película por su ID |
| `POST` | `/api/movies` | Crea una nueva película |
| `PUT` | `/api/movies/{id}` | Actualiza una película existente |
| `DELETE` | `/api/movies/{id}` | Elimina una película |
| `POST` | `/api/movies/suggest` | Genera sugerencias de películas con IA |

## 📁 Estructura del Proyecto

```
movies-play/
├── .gradle/
├── build/
├── gradle/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── movies_play/
│   │   │           ├── domain/         # Lógica de negocio
│   │   │           │   ├── dto/
│   │   │           │   ├── exception/
│   │   │           │   ├── repository/
│   │   │           │   └── service/
│   │   │           ├── persistence/    # Capa de persistencia
│   │   │           │   ├── crud/
│   │   │           │   ├── entity/
│   │   │           │   └── mapper/
│   │   │           └── web/            # Capa web
│   │   │               └── controller/
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       ├── application-prod.properties
│   │       ├── data.sql
│   │       └── schema.sql
│   └── test/
├── .gitignore
├── build.gradle
├── Dockerfile
└── README.md
```

## 🗺️ Roadmap

### ✅ Fase 1 - MVP (Completado)
- API RESTful para operaciones CRUD de películas
- Persistencia con PostgreSQL
- Integración básica de LangChain4j para sugerencias

### 🔄 Fase 2 - Mejoras y Funcionalidades (En Desarrollo)
- Implementar autenticación y autorización (JWT/OAuth2)
- Añadir un sistema de calificación de películas
- Crear endpoints de búsqueda por género o título

## 🤝 Contribuir

¡Las contribuciones son bienvenidas! Siéntete libre de abrir issues o enviar pull requests.

### Proceso de Contribución

1. Fork el proyecto
2. Clona tu fork (`git clone https://github.com/tu-usuario/movies-play.git`)
3. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
4. Commit tus cambios (`git commit -m 'feat: añade nueva funcionalidad'`)
5. Push a la rama (`git push origin feature/nueva-funcionalidad`)
6. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la **Licencia MIT**. Consulta el archivo `LICENSE` para más detalles.

## 📞 Contacto

- 📧 **Email**: galdamesvilchesf@gmail.com
- 🔗 **Proyecto**: [https://github.com/galdamesf/movies-play](https://github.com/galdamesf/movies-play)

## 🙏 Agradecimientos

- A la comunidad de **Spring Boot** y **Gradle** por sus excelentes herramientas
- A **LangChain4j** por facilitar la integración con modelos de lenguaje

---

⭐ **¡No olvides darle una estrella al proyecto si te resulta útil!**

*Hecho con 💚 por movies-play*
