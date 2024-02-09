pipeline {
    agent any

    parameters {
        password(
            name: 'SECRET_TWO',
            description: 'Second secret'
        )
    }

    stages {
        stage('read password parameters') {
            steps {
                sh '''
                   echo "Secret one: $SECRET_ONE"
                   echo "Secret two: $SECRET_TWO"
                '''
            }
        }
    }
}