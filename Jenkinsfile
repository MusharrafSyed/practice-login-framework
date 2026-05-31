pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/MusharrafSyed/practice-login-framework.git',
                    credentialsId: 'github-token'
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }


        // --- UPDATED SECTION: Allure Report Generation ---
        stage('Generate Allure Report') {
            steps {
                // The 'allure' step is provided by the Allure Jenkins Plugin.
                // The 'path' MUST be the directory containing your raw JSON files.
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']] // Points to your results
                ])
            }
        }
    }

    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
        success {
            echo 'Tests passed!'
        }
        failure {
            echo 'Tests failed!'
        }
    }
}