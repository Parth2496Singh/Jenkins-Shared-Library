def call(String DockerImage, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword('credentialsId':"dockerHubCred",passwordVariable:"dockerHubPass", usernameVariable:"dockerHubUser")]){
  sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass} "
  sh "docker image tag ${DockerImage}:${ImageTag} ${dockerhubuser}/${DockerImage}:${ImageTag}"
  sh "docker push ${dockerhubuser}/${DockerImage}:${ImageTag}"
  }
}
  
  
