pipeline {
    agent any

    environment {
        flywayArgs = "-Dflyway.url=$FLYWAYURL -Dflyway.user=$FLYWAYUSR -Dflyway.password=$FLYWAYPWD"
    }

    stages {
        stage('Checkout git') {
            steps {
                checkout scm
            }
        }

        stage('Flyway info - before migration') {
            steps {
                sh 'mvn flyway:info $flywayArgs'

            }
        }

        stage('Flyway migrate') {
            steps {
                sh 'mvn flyway:migrate $flywayArgs'
            }
        }

        stage('Flyway info - after migration') {
            steps {
                sh 'mvn flyway:info $flywayArgs'
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}