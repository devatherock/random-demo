pipeline {
    agent any

    stages {
        stage('trigger job that needs stashed file') {
            steps {
                deleteDir() // To cleanup workspace 
                sh '''
                   echo "hello from parent job" >> test.txt
                '''

                script {
                    File testFile = new File("${env.WORKSPACE}/test.txt")
                    build job: 'stashed-file', parameters: [
                        base64File(name: 'file', base64: Base64.encoder.encodeToString(testFile.bytes)),
                    ]
                }
            }
        }
    }
}