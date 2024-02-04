pipeline {
    agent any

    stages {
        stage('Init') {
            stages{
                stage('init_1') {
                    steps {
                        script {
                          env.DUMMY = "dummy-value"
                        }
                    }
                }
                stage('init_2') {
                   echo "Env variable value: ${env.DUMMY}"
                }
            }
        }

        stage('run') {
            agent { docker 'alpine' }

            stages {
                stage('actually do stuff') {
                    steps {
                        sh('printenv')
                    }
                }
            }    
        }
    }
}