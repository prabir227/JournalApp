pipeline {
    agent any

    environment {
        COMPOSE_FILE = 'docker-compose.yml'
    }

    stages {
        stage('Clone Repository') {
            steps {
                // Explicitly specify the branch as 'main'
                git branch: 'main', url: 'https://github.com/prabir227/JournalApp.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Rebuild Docker Containers') {
            steps {
                sh 'docker compose down'
                sh 'docker compose up --build -d'
            }
        }
    }
}
