pipeline {
    agent any

    parameters {
        password(
            name: 'SECRET_TWO',
            description: 'Second secret'
        )
    }

    stages {
        stage('read password parameter') {
            steps {
                sh '''
                   echo "Secret two: $SECRET_TWO"
                '''
            }
        }
    }
}