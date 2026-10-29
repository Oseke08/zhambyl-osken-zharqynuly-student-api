# zhambyl-osken-zharqynuly-student-api

Student: Zhambyl Osken Zharqynuly
Group: IT-2 2307
ID: 37437

Spring Boot CRUD API for students, backed by PostgreSQL, containerized with Docker
Compose and built by a Jenkins pipeline. Full instructions: see the Run section (merged from main and documentation branches).

## Change: partial update (feature/zhambyl-osken-zharqynuly-crud)
Author: Zhambyl Osken Zharqynuly. Added `PATCH /api/students/{id}` so that a client can update only some fields
of a student. Fields that are not sent keep their current values.
