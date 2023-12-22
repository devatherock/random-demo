pipeline {
    agent any

    parameters {
        stashedFile(name: 'inputFile', description: 'some file')
    }

    stages {
        stage('Find file name') {
            steps {
               deleteDir() // To cleanup workspace 
               sh 'mkdir test'

               dir('test') {
                   unstash 'inputFile'
               }

               script {
                   String fileName = sh(script: '''#!/bin/bash
                       cd test
                       ls
                   ''', returnStdout: true).trim()
                   println("The input filename: ${fileName}")
               }
            }
        }
    }
}