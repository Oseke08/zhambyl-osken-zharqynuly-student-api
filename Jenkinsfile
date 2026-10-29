// Jenkins pipeline for Zhambyl Osken Zharqynuly (IT-2 2307, ID 37437)
pipeline {
    agent any

    environment {
        STUDENT_NAME = 'Zhambyl Osken Zharqynuly'
        IMAGE_NAME   = 'zhambyl-osken-zharqynuly-student-api'
        IMAGE_TAG    = 'v1.0-id37437'
        IMAGE_REF    = "zhambyl-osken-zharqynuly-student-api:v1.0-id37437"
    }

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Student: ${STUDENT_NAME} | IT-2 2307 | ID 37437"
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building application for ${STUDENT_NAME}"
                sh 'chmod +x gradlew && ./gradlew --no-daemon clean compileJava'
            }
        }

        stage('Test') {
            steps {
                echo "Running automated tests for ${STUDENT_NAME}"
                sh './gradlew --no-daemon test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Docker Build') {
            steps {
                echo "Building Docker image ${IMAGE_REF} for ${STUDENT_NAME}"
                sh "docker build -t ${IMAGE_REF} ."
            }
        }

        stage('Verify') {
            steps {
                echo "Verifying image ${IMAGE_REF} for ${STUDENT_NAME}"
                sh """
                    docker image inspect ${IMAGE_REF} --format 'Image: {{.RepoTags}} Size: {{.Size}} bytes Created: {{.Created}}'
                """
            }
        }
    }

    post {
        success { echo "Pipeline SUCCESS for ${STUDENT_NAME}" }
        failure { echo "Pipeline FAILED for ${STUDENT_NAME} - check the stage above" }
    }
}
