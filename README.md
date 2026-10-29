# zhambyl-osken-zharqynuly-student-api

- **Student:** Zhambyl Osken Zharqynuly
- **Group:** IT-2 2307
- **ID:** 37437

Spring Boot CRUD API for students, backed by PostgreSQL, containerized with Docker Compose and built by a Jenkins pipeline.

## Project structure
```
scripts/   Bash system report script (Zhambyl_Osken_Zharqynuly_system_report.sh)
logs/      system report log and log analysis
backups/   backup of README.md with student name in filename
src/       Spring Boot source and tests
Dockerfile, docker-compose.yml, Jenkinsfile, build.gradle, settings.gradle
```

## Endpoints
| Method | URL | Purpose |
|---|---|---|
| GET | /api/students/owner | student name, group, ID |
| POST | /api/students | create student (201) |
| GET | /api/students | list all students |
| GET | /api/students/{id} | get one student (404 if missing) |
| PUT | /api/students/{id} | replace student |
| PATCH | /api/students/{id} | partial update |
| DELETE | /api/students/{id} | delete (204) |

## Run from scratch (run these on your own machine)
1. Create the Gradle wrapper once (it is not stored in this archive): `gradle wrapper --gradle-version 8.10` (requires a local Gradle install), then commit `gradlew`, `gradlew.bat`, and `gradle/`.
2. Create your local env file: `cp .env.example .env` and set a real `POSTGRES_PASSWORD`. Do not commit `.env`.
3. Run tests: `./gradlew test`
4. Start the stack: `docker compose up -d --build`
5. Check: `docker compose ps` (db should show `healthy`), `docker compose logs app`
6. Test the API:
```
curl -i http://localhost:8080/api/students/owner
curl -i -X POST http://localhost:8080/api/students -H "Content-Type: application/json" \
  -d '{"fullName":"Zhambyl Osken Zharqynuly","email":"zhambyl@example.com","course":"DevOps"}'
curl -i http://localhost:8080/api/students
curl -i http://localhost:8080/api/students/1
curl -i -X PUT http://localhost:8080/api/students/1 -H "Content-Type: application/json" \
  -d '{"fullName":"Zhambyl Osken Zharqynuly","email":"zhambyl2@example.com","course":"Cloud"}'
curl -i -X PATCH http://localhost:8080/api/students/1 -H "Content-Type: application/json" -d '{"course":"CI/CD"}'
curl -i -X DELETE http://localhost:8080/api/students/1
curl -i http://localhost:8080/api/students/999
```
7. Script: `./scripts/Zhambyl_Osken_Zharqynuly_system_report.sh`

## Git and GitHub
Remote push (after creating an empty GitHub repo named `zhambyl-osken-zharqynuly-student-api`):
```
git remote add origin https://github.com/<your-username>/zhambyl-osken-zharqynuly-student-api.git
git push -u origin main
git push origin feature/zhambyl-osken-zharqynuly-crud feature/zhambyl-osken-documentation
git push origin v1.0-id37437
```

## Jenkins
Job name: `Zhambyl_Osken_Zharqynuly_Student_API`, pipeline from SCM pointing to your GitHub repo, script path `Jenkinsfile`. Add a GitHub webhook (`http://<jenkins-host>/github-webhook/`) for automatic triggering.
