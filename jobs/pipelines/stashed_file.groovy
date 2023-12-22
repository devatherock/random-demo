pipeline {
    agent any

    parameters {
        // Requires https://plugins.jenkins.io/file-parameters/ plugin
        stashedFile(name: 'INPUT_FILE', description: 'some file')
    }

    stages {
        stage('Find file name') {
            steps {
                deleteDir() // To cleanup workspace 
                unstash 'INPUT_FILE'
                sh 'mv INPUT_FILE $INPUT_FILE_FILENAME'

                script {
                    String fileName = env.INPUT_FILE_FILENAME
                    String fileContents = sh(script: "cat ${fileName}", returnStdout: true).trim()
                    println("File name: ${fileName}, contents: ${fileContents}")
                }
            }
        }
    }
}