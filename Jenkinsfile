pipeline {
    agent any
    stages {
            stage('Compile and Clean') { 
                steps {
                       bat 'mvn compile'
                      }
            }
       
	        stage('Junit5 Test') { 
                 steps {
	                bat 'mvn test'
                  }
            }

	    stage('Jacoco Coverage Report') {
        	     steps{
            		jacoco()
		          }
	        }
		stage('SonarQube'){
			steps{
				bat label: '', script: '''mvn sonar:sonar \
				-Dsonar.host.url= http://localhost:9000/ \
				-Dsonar.login=squ_163df5f6e6aee5b49a7b84e03979559df119da54'''
				}	
   			}
        stage('Maven Build') { 
            steps {
                bat 'mvn clean install'
                  }
            }
        stage('Build Docker image'){
           steps {
                      //   	docker build -t nodejs-server -f Dockerfile.arg --build-arg UBUNTU_VERSION=18.04
		             //--build-arg CUDA_VERSION=10.0
                     //bat 'docker build -t  docker.repository.esi.adp.com/clientcentral/training:docker_jenkins_springboot:${BUILD_NUMBER} .'
           	    bat 'docker build -t  ey-samplejenkins --build-arg VER=1.0 .'
		         }
             }
       
        stage('Docker deploy'){
            steps {
                bat 'docker run -itd -p  8086:8086 ey-samplejenkins '
             }
        }
     
    }
}
