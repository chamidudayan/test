# User Management Dashboard - Spring Boot Project

## Dev Branch

## What this contains
- Spring Boot backend (Java) with a simple User entity and CRUD + pagination + sorting endpoints.
- Static HTML/JS UI located at `src/main/resources/static/user-dashboard.html`.
- Uses H2 in-memory database for easy testing.

## Run
1. Build: `mvn package`
2. Run: `mvn spring-boot:run` or run the generated jar in `target/`.
3. Open UI: `http://localhost:8080/user-dashboard.html`

## Notes
- The API base path is `/users`.
- Pagination and sorting query params: `page`, `size`, `sortField`, `sortDir`.