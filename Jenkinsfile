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
                sh "mvn flyway:info"
            }
        }

        stage('Flyway migrate') {
            steps {
                sh "mvn flyway:migrate"
            }
        }

        stage('Flyway info - after migration') {
            steps {
                sh "mvn flyway:info"
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}