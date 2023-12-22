@NonCPS
void triggerStashedFileJob(def fileItem) {
    build job: 'stashed-file', parameters: [
        stashedFile(name: 'INPUT_FILE', file: fileItem),
    ]
}

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
                    def factory = new org.apache.commons.fileupload.disk.DiskFileItemFactory()
                    def fileItem = factory.createItem('file', 'text/plain', false, 'test-copy.txt')
                    fileItem.outputStream << testFile.bytes

                    triggerStashedFileJob(fileItem)
                }
            }
        }
    }
}