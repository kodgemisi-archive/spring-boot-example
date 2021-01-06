pipeline {
  agent any
  stages {
    stage('Validate') {
      steps {
        sh 'mvn validate'
      }
    }

    stage('Compile') {
      steps {
        sh 'mvn compile'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Build') {
      post {
        success {
          junit 'target/surefire-reports/**/*.xml'
        }

      }
      steps {
        sh 'mvn package'
      }
    }

    stage('Deliver') {
      steps {
        sh 'java -jar target/*.jar'
      }
    }

  }
}