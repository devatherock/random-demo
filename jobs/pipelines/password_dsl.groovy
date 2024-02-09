pipeline {
    agent any

    stages {
        stage('read password parameter') {
            steps {
                sh '''
                   echo "Secret one: $SECRET_ONE"
                '''
            }
        }
    }
}