@Library('security-pipeline@main') _
pipeline {
    agent any
    stages {
        stage('Example') {
            steps {
                script {
                    secretDetection()   
                }
            }
        }
    }
}
