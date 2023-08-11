pipeline {
    agent any

    stages {
        stage('CHECKOUT') {
            steps {
                git url: 'https://github.com/banti27/tryeasy-recordkeeping.git', branch: 'master'
            }
        }
        /* stage('BUILD PROJECT') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        } */
        stage('BUILD IMAGE') {
            steps {
                // Retrieve an authentication token and authenticate your Docker client to your registry
                // sh 'aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 433905648701.dkr.ecr.ap-south-1.amazonaws.com'

                // Build your Docker image using the following command.
                sh 'docker build -t tryeasy .'
            }
        }
        /* stage('PUSH IMAGE TO REPOSITORY') {
            steps {
                // run the above created docker container
                // sh 'docker run -dt --name tryeasy-recordkeeping-container -p 9000:9000 tryeasy-recordkeeping:latest'


                // After the build completes, tag your image so you can push the image to this repository
                sh 'docker tag tryeasy:latest 433905648701.dkr.ecr.ap-south-1.amazonaws.com/tryeasy:latest'

                // Run the following command to push this image to your newly created AWS repository
                sh 'docker push 433905648701.dkr.ecr.ap-south-1.amazonaws.com/tryeasy:latest'
            }
        } */

    }
}
