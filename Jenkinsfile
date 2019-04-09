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
                sh "mvn -Dflyway.url=\$ENV.flywayurl -Dflyway.user=\$ENV.flywayusr -Dflyway.password=\$ENV.flywaypwd flyway:info"
            }
        }

        stage('Flyway migrate') {
            steps {
                sh "mvn -Dflyway.url=\$ENV.flywayurl -Dflyway.user=\$ENV.flywayusr -Dflyway.password=\$ENV.flywaypwd flyway:migrate"
            }
        }

        stage('Flyway info - after migration') {
            steps {
                sh "mvn -Dflyway.url=\$ENV.flywayurl -Dflyway.user=\$ENV.flywayusr -Dflyway.password=\$ENV.flywaypwd flyway:info"
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}