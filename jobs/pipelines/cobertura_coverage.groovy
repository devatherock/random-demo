pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                sh """#!/bin/bash
                ./gradlew clean cobertura
                """
            }
        }
    }

    post {
    	success {
		    cobertura coberturaReportFile: '**/reports/cobertura/coverage.xml'
            recordCoverage(tools: [[parser: 'COBERTURA']], id: 'cobertura', name: 'Cobertura Coverage', sourceDirectories: [[path: '**/src']])
    	}
    }
}