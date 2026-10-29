# TASK_CHECKLIST — DevOps midterm (Zhambyl Osken Zharqynuly, IT-2 2307, ID 37437)

Status legend:
- **DONE-VERIFIED** — done and checked in this environment
- **PREPARED** — files/commands ready, must be run on the student's machine/GitHub/Jenkins
- **BLOCKED** — not possible in this environment (reason given)

| # | Requirement | Status | Evidence / note |
|---|---|---|---|
| 1.1 | Create directory structure (scripts, logs, backups, src) and files Dockerfile, docker-compose.yml, Jenkinsfile, build.gradle, README.md | DONE-VERIFIED | `find` listing in project |
| 1.1 | Personal Bash script `Zhambyl_Osken_Zharqynuly_system_report.sh` | DONE-VERIFIED | scripts/ |
| 1.1 | Empty log file created | DONE-VERIFIED | logs/Zhambyl_Osken_Zharqynuly_system_report.log (filled by script run) |
| 1.1 | Display tree and verify files exist | DONE-VERIFIED | run in terminal (see SCREENSHOT_INDEX) |
| 1.2 | Script shows/saves name, date/time, user, OS/kernel, CPU/memory, disk usage, free disk space to personal log | DONE-VERIFIED | script run output |
| 1.3 | chmod: owner rwx, group/others read-only (744) | DONE-VERIFIED | `ls -l` shows `-rwxr--r--` |
| 1.3 | Backup of README.md with student name in filename | DONE-VERIFIED | backups/README_Zhambyl_Osken_Zharqynuly_*.md |
| 1.3 | Verify permissions with ls -l and backup content | DONE-VERIFIED | terminal output |
| 1.4 | List processes, identify Java process | DONE-VERIFIED (none running) | no java process was running; command documented |
| 1.4 | Last five lines of log | DONE-VERIFIED | terminal output |
| 1.4 | Search log for surname, save to analysis file | DONE-VERIFIED | logs/Zhambyl_Osken_Zharqynuly_log_analysis.txt |
| 1.4 | Explain > vs >> | DONE | DEFENSE_ANSWERS.md #58 |
| 2.1 | Git repo init, username/email config | DONE-VERIFIED | commit author set; email is a PLACEHOLDER — change to your real one |
| 2.1 | .gitignore | DONE-VERIFIED | .gitignore |
| 2.1 | Initial commit with student's name | DONE-VERIFIED | a76391b "Initial commit: Zhambyl Osken Zharqynuly Student API" |
| 2.2 | Branch feature/zhambyl-osken-crud (name includes surname/name) | DONE-VERIFIED | branch `feature/zhambyl-osken-zharqynuly-crud` |
| 2.2 | Improve one CRUD op (PATCH added) | DONE-VERIFIED | d20148f |
| 2.2 | README updated with name and description | DONE-VERIFIED | 1e37e0c |
| 2.2 | At least two meaningful commits | DONE-VERIFIED | d20148f, 1e37e0c |
| 2.2 | Merge into main | DONE-VERIFIED | 20c271d (--no-ff merge) |
| 2.3 | Branch feature/...-documentation | DONE-VERIFIED | `feature/zhambyl-osken-documentation` |
| 2.3 | Modify same README line on two branches, merge, conflict | DONE-VERIFIED | 8b0d486 vs 8184cc7 |
| 2.3 | Resolve conflict manually and commit | DONE-VERIFIED | 294ce05 |
| 2.3 | Show final Git history | DONE-VERIFIED | `git log --graph --all` output |
| 2.4 | Create GitHub repo `zhambyl-osken-zharqynuly-student-api` | PREPARED | needs your GitHub account; commands in README |
| 2.4 | Push main and feature branches | PREPARED | no network in this environment |
| 2.4 | Tag v1.0-id37437 | DONE-VERIFIED (local) | local annotated tag; push with `git push origin v1.0-id37437` |
| 2.4 | Show remote URL, history, branches, tag | PREPARED | run `git remote -v` after adding remote |
| 2.4 | Explain why .env/passwords not committed | DONE | DEFENSE_ANSWERS.md #37 |
| 3.1 | Multi-stage Dockerfile (JDK build, JRE runtime, Gradle, copy JAR, EXPOSE 8080) | PREPARED — NOT BUILT | Dockerfile needs gradle wrapper (see BLOCKED note below) |
| 3.1 | Image name/tag `zhambyl-osken-zharqynuly-student-api:v1.0-id37437` | PREPARED | docker-compose.yml, Jenkinsfile |
| 3.1 | Build image and show size/inspect | PREPARED — NOT RUN | no Docker daemon here |
| 3.2 | docker-compose.yml: app + PostgreSQL, env vars, named volume, network, health check | DONE (file validated as YAML) | docker-compose.yml |
| 3.2 | Start services, both running, app uses service name `db` | PREPARED — NOT RUN | no Docker daemon here |
| 3.3 | ps / logs / inspect / exec / stop+start / rebuild / persistence check | PREPARED — NOT RUN | commands in README and SCREENSHOT_INDEX |
| 3.4 | API tests: create, list, get by id, update, delete, nonexistent id | PREPARED — NOT RUN | curl commands in README; test data uses student name; automated test StudentApiTest covers the same flow |
| 4.1 | Jenkins job `Zhambyl_Osken_Zharqynuly_Student_API` with repo, JDK/Gradle/Docker agent, credentials | PREPARED — NOT RUN | needs Jenkins server |
| 4.2 | Jenkinsfile with Checkout, Build, Test, Docker Build, Verify; stops on failure; image name; prints name | DONE (file written) — NOT RUN | Jenkinsfile |
| 4.3 | Successful run, controlled failure on test branch, fix, rerun | PREPARED — NOT RUN | steps must be done on a test branch in your Jenkins |
| 4.4 | Webhook or polling, auto trigger, build history, console output | PREPARED — NOT RUN | webhook URL in README |
| 4.4 | CI vs CD explanation | DONE | DEFENSE_ANSWERS.md #74–75 |
| Ind. | Individualization: Surname_Name script, log/backup names, branches, commits, image, tag, Jenkins job, console name, app name/test data | DONE-VERIFIED (except Jenkins job and GitHub, which are PREPARED) | see above |
| Defense | Answers to all defense questions | DONE | DEFENSE_ANSWERS.md (82 answers; some questions merged where they repeat) |
| Pkg | ZIP archive of project | DONE | /mnt/user-data/outputs/zhambyl-osken-zharqynuly-student-api.zip |
| Shots | Real and mockup screenshots | NOT CAPTURED | see SCREENSHOT_INDEX.md |

## BLOCKED / important notes
1. **Gradle wrapper not included.** The sandbox has no Gradle and no network, so `gradlew` and `gradle/wrapper/` could not be generated. The Dockerfile and Jenkinsfile call `./gradlew`. Run `gradle wrapper --gradle-version 8.10` locally, then commit it. Without this step the Docker build and Jenkins Build stage will fail.
2. **The application was not compiled or tested here.** The Java/Gradle dependencies could not be downloaded, so `./gradlew test` has not been run. Run it locally first.
3. **Docker, GitHub, and Jenkins were not used.** No Docker daemon, GitHub account, or Jenkins server is available in this environment.
4. **Personal values to change:** Git email is a placeholder (`zhambyl.student@example.com`).
