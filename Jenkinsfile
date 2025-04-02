pipeline {
    agent any
   
    stages {
        stage('Maven clean') {
            steps {
                bat 'mvn clean'
            }
        }
      //  stage('Test') {
        //    steps {
       //         echo 'Test'
        //    }
       // }
        stage('Build ') {
            steps {
                  bat 'docker build -t  jenkinssampleproject --build-arg VER=1.0 .'
            }
        }
        stage('Deploy') {
            steps {
                 bat 'docker push aruna708/jenkinssampleproject'
            }
        }
         stage('Run') {
            steps {
                bat 'docker run -itd -p  8086:8086 jenkinssampleproject'
            }
        }
        
    }
}
