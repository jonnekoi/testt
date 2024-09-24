pipeline {
    agent any
    environment {
        DOCKERHUB_REPO = 'jonnekoi/test'
        DOCKER_IMAGE_TAG = 'latest'
    }
    tools {
        maven 'MAVEN'
    }
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository configured in Jenkins
                checkout scm
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'DOCKERHUB_CREDENTIALS_ID') {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
    post {
        always {
            echo 'Cleaning up...'
            // Optional: Perform any clean-up tasks like removing Docker images if needed
        }
        success {
            echo 'Docker image successfully pushed!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
