pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                checkout scm
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}
