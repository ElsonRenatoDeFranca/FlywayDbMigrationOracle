pipeline {
    agent any

    stages {
        stage('Checkout git') {
            steps {
                checkout scm
            }
        }

        stage('Flyway info - before migration') {
            steps {
                sh "mvn compile flyway:info"
            }
        }

        stage('Flyway migrate') {
            steps {
                sh 'echo "flyway migrate"'
            }
        }

        stage('Flyway info - after migration') {
            steps {
                sh 'echo "flyway info"'
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}