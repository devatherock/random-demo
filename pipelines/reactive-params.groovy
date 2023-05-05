pipeline {
    agent any
    stages {
        stage('Show parameter values') {
            steps {
                echo "PARAM_2: ${params.PARAM_2}, PARAM_3: ${params.PARAM_3}, SOME_PARAM: ${params.SOME_PARAM}"
            }
        }
    }
}