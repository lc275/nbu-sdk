pipeline {
  agent any
  stages {
    stage('git') {
      steps {
        git(url: 'https://github.com/lc275/nbu-sdk.git', branch: 'master', poll: true)
      }
    }

  }
}