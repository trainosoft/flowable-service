node {
  stage('SCM-Checkout'){
    git 'https://github.com/trainosoft/flowable-service'
  }
  
  stage('Compile-package'){
    sh 'mvn -B -DskipTests clean package'

  }
  
  
}
