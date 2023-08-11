pipeline {
    agent any

    stages {
        stage('CHECKOUT') {
            steps {
                git url: 'https://github.com/banti27/tryeasy-recordkeeping.git', branch: 'master'
            }
        }
        stage('BUILD') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }
        
    }
}
