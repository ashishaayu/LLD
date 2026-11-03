# Spring Boot Demo

Standalone Maven Spring Boot project with Java 21, Spring Web, validation, logging, records, a configured outbound RestClient, and in-memory storage behind a repository interface.

## Open in IntelliJ

File → Open → select this directory's `pom.xml` → Open as Project. Select JDK 22 and wait for Maven import. Run `SpringbootDemoApplication.main()`.

## Run from terminal

```bash
cd springboot-demo
./mvn-local spring-boot:run
```

The helper selects installed Java 22 on this Mac and uses the project's prepopulated Maven cache. Standard `mvn spring-boot:run` also works with a compatible JDK and network access for the initial dependency download.

Runs on port **8081**, so it can coexist with the interview API on 8080.

```bash
curl -i http://localhost:8081/api/items \
  -H 'Content-Type: application/json' \
  -d '{"name":"Hello Spring Boot"}'
```

POST returns 201 with `id`, `name`, and `createdAt`. GET `/api/items/{id}` retrieves the item; invalid names return 400, unknown IDs return 404. Storage resets on restart. `requests.http` contains runnable IDE requests.

## Build and test

```bash
./mvn-local test
./mvn-local package
java -jar target/springboot-demo-0.0.1-SNAPSHOT.jar
```

Source: `src/main/java/com/example/interview/`. Flow: `ItemController` → `ItemService` → `ItemRepository`. HTTP client/timeouts and logging are configured in `HttpClientConfig` and `src/main/resources/application.properties`.
