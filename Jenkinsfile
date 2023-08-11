pipeline {
    agent any

    stages {
        stage('CHECKOUT') {
            steps {
                git url: 'https://github.com/banti27/tryeasy-recordkeeping.git', branch: 'master'
            }
        }
        stage('BUILD PROJECT') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }
        stage('BUILD IMAGE') {
            steps {
                sh 'docker build -t tryeasy-recordkeeping:latest .'
            }
        }
        stage('RUN IMAGE') {
            steps {
                sh 'docker run -dt --name tryeasy-recordkeeping-container -p 9000:9000 tryeasy-recordkeeping:latest'
            }
        }

    }
}
