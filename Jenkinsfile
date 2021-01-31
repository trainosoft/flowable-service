node {
  stage('SCM-Checkout'){
    git 'https://github.com/trainosoft/flowable-service'
  }
  
  stage('Compile-package'){
    def mvnHome = tool name: 'Jenkins-maven', type: 'maven'
    sh "${mvnHome}/bin/mvn package"
  }
  
  
}
