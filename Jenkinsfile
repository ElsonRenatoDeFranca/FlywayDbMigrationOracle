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
                sh "mvn -Dflyway.url=jdbc:oracle:thin:@ech-10-157-150-237.mastercard.int:1527:devcloud -Dflyway.user=FLYWAYUSER -Dflyway.password=flywayuser123 flyway:info"
            }
        }

        stage('Flyway migrate') {
            steps {
                sh "mvn -Dflyway.url=jdbc:oracle:thin:@ech-10-157-150-237.mastercard.int:1527:devcloud -Dflyway.user=FLYWAYUSER -Dflyway.password=flywayuser123 flyway:migrate"
            }
        }

        stage('Flyway info - after migration') {
            steps {
                sh "mvn -Dflyway.url=jdbc:oracle:thin:@ech-10-157-150-237.mastercard.int:1527:devcloud -Dflyway.user=FLYWAYUSER -Dflyway.password=flywayuser123 flyway:info"
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}