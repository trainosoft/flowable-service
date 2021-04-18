pipeline {
  
  tools {
        maven 'Maven 3.2.5'
  }
  
  stage('SCM-Checkout'){
    git 'https://github.com/trainosoft/flowable-service'
  }
  
  stage('Compile-package'){
    steps{
      sh 'mvn -B -DskipTests clean package'
    }
  }

}
