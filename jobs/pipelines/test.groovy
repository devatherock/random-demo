pipeline {
    agent { docker 'alpine' }

    stages {
        stage('Test') {
            steps {
                sh('printenv')
            }
        }
    }
}