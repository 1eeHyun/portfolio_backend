# Portfolio Backend

A **Spring Boot** REST API that powers the portfolio website—serving **About, Courses, Projects, Certifications, Education, Skills**, and optional **Contact** endpoints.  
It also exposes **admin endpoints** for managing content.

> Frontend relies on (at minimum):  
> `/project-headers`, `/project-headers/{id}`, `/project-items/{id}`, `/course`, `/about`, and (optional) `/Contact`.

---

## Features

- Project **headers** & **items** (internal/external, display modes, tech stacks)
- Courses with year grouping (e.g., `999` = “in progress”)
- About, Certifications, Education, Skills
- Optional Contact API
- **Admin CRUD** endpoints (guarded by an interceptor + token)
- CORS configured for the portfolio frontend
- OpenAPI (springdoc) API docs

---

## Tech Stack

- **Java 17+**
- **Spring Boot** (Web, Validation, Data JPA)
- Database: **H2** (dev) / **MySQL** / **PostgreSQL**
- OpenAPI via **springdoc**
- **Gradle** or **Maven**

---

## Project Structure

```
src/main/java/.../portfolio-backend
├─ builder
│  ├─ about
│  │  └─ AboutResponseBuilder
│  ├─ certificate
│  │  └─ CertificateBuilder
│  ├─ course
│  │  └─ CourseResponseBuilder
│  ├─ project
│  │  └─ ProjectDTOMapper
│  └─ skill
│     └─ SkillResponseBuilder
├─ config
│  ├─ AdminAuthInterceptor
│  ├─ CorsConfig
│  └─ WebConfig
├─ controller
│  ├─ about (AboutApiDocs, AboutController, AdminAboutApiDocs, AdminAboutController)
│  ├─ certificate (CertificateApiDocs, CertificateController, AdminCertificateApiDocs, AdminCertificateController)
│  ├─ contact (ContactApiDocs, ContactController)
│  ├─ course (CourseApiDocs, CourseController, AdminCourseApiDocs, AdminCourseController)
│  ├─ education (EducationApiDocs, EducationController, AdminEducationApiDocs, AdminEducationController)
│  └─ project
│     ├─ ProjectHeaderApiDocs, ProjectHeaderController
│     ├─ ProjectItemApiDocs, ProjectItemController
│     ├─ AdminProjectHeaderController, AdminProjectItemController
│     └─ AdminProjectHeaderApiDocs
├─ domain
│  ├─ about / certificate / contact / course / education / skill
│  └─ project (DisplayMode, ProjectHeader, ProjectItem, ProjectImage, ProjectOrigin)
├─ dto
├─ exception
├─ repository (about / certificate / contact / course / education / project / skill)
├─ service
│  ├─ about / certificate / contact / course / education / skill
│  └─ project (ProjectHeaderService, ProjectHeaderServiceImpl, ProjectItemService, ProjectItemServiceImpl)
├─ util
└─ validator
```

---

## Getting Started

### Prerequisites
- JDK **17+**
- A database (H2 for local dev, or MySQL/PostgreSQL)
- Gradle or Maven

### Configuration

Create `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:portfolio;MODE=MySQL;DB_CLOSE_DELAY=-1
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate.format_sql: true
  jackson:
    serialization:
      WRITE_DATES_AS_TIMESTAMPS: false

# CORS: set your frontend origin(s)
app:
  cors:
    allowed-origins: "http://localhost:5173,https://your-portfolio.com"

# Admin token (used by AdminAuthInterceptor)
security:
  admin-token: ${ADMIN_TOKEN:change-me}
```

### Run

**Gradle**
```bash
./gradlew bootRun
```

**Maven**
```bash
mvn spring-boot:run
```

Server starts on **http://localhost:8080** by default.

---

## API Overview

### Projects

#### GET `/project-headers`
Returns a list of project header cards.

```json
[
  {
    "id": 4,
    "title": "Forge UI",
    "subtitle": "A small design system for demos",
    "description": "Optional long description",
    "year": 2024,
    "coverImageUrl": "https://…/cover.jpg",
    "projectCount": 3,
    "displayMode": "INTERNAL | LIVE | GITHUB | DOCS | VIDEO",
    "externalUrl": "https://demo.example.com",
    "githubUrl": "https://github.com/you/repo",
    "liveUrl": "https://demo.example.com",
    "hasExternalLink": true,
    "techStacks": ["React", "Tailwind", "Spring Boot"]
  }
]
```

#### GET `/project-headers/{id}`
Returns a header with its project items.

```json
{
  "id": 4,
  "title": "Forge UI",
  "subtitle": "Design system",
  "description": "Longer description…",
  "year": 2024,
  "coverImageUrl": "https://…/cover.jpg",
  "techStacks": ["React", "Tailwind"],
  "projects": [
    {
      "id": 401,
      "title": "Core components",
      "summary": "Buttons, inputs…",
      "description": "Details…",
      "coverImageUrl": "https://…/thumb.jpg",
      "images": [
        { "url": "https://…/shot1.png", "order": 0 },
        { "url": "https://…/demo.mp4", "order": 1 }
      ],
      "liveUrl": "https://demo.example.com/core",
      "githubUrl": "https://github.com/you/repo"
    }
  ]
}
```

#### GET `/project-items/{id}`
Returns a single project item (full detail).

```json
{
  "id": 401,
  "title": "Core components",
  "summary": "Buttons, inputs…",
  "description": "Details…",
  "coverImageUrl": "https://…/thumb.jpg",
  "images": [{ "url": "https://…/shot1.png", "order": 0 }],
  "liveUrl": "https://demo.example.com/core",
  "githubUrl": "https://github.com/you/repo",
  "techStacks": ["React", "Tailwind"]
}
```

### Courses

#### GET `/course`
Returns a list of courses.

```json
[
  {
    "id": 101,
    "name": "Modern React",
    "provider": "Udemy",
    "description": "Hooks, Zustand, Suspense…",
    "logoUrl": "https://…/udemy.png",
    "year": 2024
  },
  {
    "id": 102,
    "name": "Spring Boot Mastery",
    "provider": "Inflearn",
    "year": 999
  }
]
```
> The frontend treats `year: 999` as **“in progress”**.

### About / Education / Certificates / Skills

- `GET /about`  
- `GET /education`  
- `GET /certificate`  
- `GET /skill`  

*(Exact DTOs may vary; they generally mirror the domain models.)*

### Contact (optional)

- `POST /contact` – Submit a contact message  
- `GET /contact` – (Admin) list messages

---

## Admin Endpoints

CRUD endpoints for the same resources, e.g.:

- `/admin/project-headers/**`
- `/admin/project-items/**`
- `/admin/courses/**`
- `/admin/education/**`
- `/admin/certificate/**`
- `/admin/about/**`

Protected by **`AdminAuthInterceptor`**. Send the admin token:

```
X-ADMIN-TOKEN: <your-admin-token>
```
> Adjust header name/value in `AdminAuthInterceptor` or config as needed.

---

## CORS

Configured in `CorsConfig`.  
Set allowed origins via `application.yml` → `app.cors.allowed-origins`.

---

## API Docs

Springdoc/OpenAPI is enabled via `*ApiDocs` classes.

- Swagger UI: `/swagger-ui/index.html`  
- OpenAPI JSON: `/v3/api-docs`

---

## Development Tips

- Use **H2** in-memory DB for local dev; switch to MySQL/Postgres in prod.
- Keep image/video URLs public or serve via a static bucket/CDN.
- For “external” projects, populate `displayMode`, `externalUrl`, `githubUrl`, `liveUrl` appropriately.

---

## License

MIT (or your preferred license). Add a `LICENSE` file if needed.

---

## Contributing

PRs and issues are welcome. Please include:
- Problem description
- Reproduction steps
- Proposed fix or test plan
