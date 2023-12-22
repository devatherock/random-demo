pipeline {
    agent any

    stages {
        stage('Find file name') {
            steps {
               sh 'mkdir temp'

               dir('temp') {
                   unstash 'inputFile'
               }
               
               script {
                   String fileName = sh(script: '''#!/bin/bash
                       cd temp
                       ls
                   ''', returnStdout: true).trim()
                   println("The input filename: ${fileName}")
               }
            }
        }
    }
}