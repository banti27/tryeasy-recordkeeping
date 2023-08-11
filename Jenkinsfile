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
                script{
                    app = docker.build("tryeasy-recordkeeping-img")
                }
            }
        }

    }
}
