pipeline {
    agent any
    stages {
        stage('Build KafelkiTest code') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Execute KafelkiTest') {
            steps {
                sh 'mvn KafelkiTest'
            }
        }
        stage('Generate allure report') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}