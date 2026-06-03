pipeline {
    agent any

    tools {
        jdk 'JDK-21.0.10'
        maven 'Maven-3.9.14'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/prabhasaini/TestRestAssuredAPIPrabha', branch: 'main'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {

           // junit 'target/surefire-reports/*.xml'
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'

        }
    }
}
