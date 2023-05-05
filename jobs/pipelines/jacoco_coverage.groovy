pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                sh """#!/bin/bash
                ./gradlew clean build
                """
            }
        }
    }

    post {
    	success {
		    jacoco(
                execPattern: '**/build/jacoco/*.exec',
                classPattern: '**/build/classes/java/main',
                sourcePattern: '**/src/main'
            )
    	}
    }
}