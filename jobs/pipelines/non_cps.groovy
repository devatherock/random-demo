import groovy.xml.XmlUtil
import groovy.util.XmlSlurper

@NonCPS
void updateFile() {
    String xmlText = '''
    <configuration>
        <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
            <withJansi>true</withJansi>
            <encoder>
                <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{10} - %msg%n</pattern>
            </encoder>
        </appender>
    
        <root level="INFO">
            <appender-ref ref="STDOUT" />
        </root>
    </configuration>
    '''.stripIndent().trim()
    def xml = new XmlSlurper().parseText(xmlText)

    def modifiedXml = XmlUtil.serialize(xml)
    writeFile(file: 'logback.xml', text: modifiedXml)
}

pipeline {
    agent any

    stages {
        stage('parse xml') {
            steps {
                script {
                    updateFile()
                }
            }
        }

        stage('read xml') {
            steps {
                sh 'cat logback.xml'
            }
        }
    }
}