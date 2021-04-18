pipeline {
  
  def tomcatHome = '//Users//Volumes//Trainings//Flowable//'
  agent any

  tools {
    maven 'Maven 3.6.3'
  }
  
  stages {
    
    stage('SCM-Checkout'){
      steps{
        git 'https://github.com/trainosoft/flowable-service'
      }
    }
  
    stage('Build'){
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
    
     stage('Deploy'){
      steps {
        sh 'cp target/flowable-service-task-demo.jar ${tomcatHome}/flowable-service-task-demo.jar'
      }
    }
    
  }
}
