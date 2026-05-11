def call(String DockerImage, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: "dockerHubCred", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]){
    // Use the more secure stdin login
    sh "echo ${env.dockerHubPass} | docker login -u ${env.dockerHubUser} --password-stdin"
    
    // Tag the local image for the remote repo
    sh "docker image tag ${DockerImage}:${ImageTag} ${dockerhubuser}/${DockerImage}:${ImageTag}"
    
    // Push the remote-tagged image
    sh "docker push ${dockerhubuser}/${DockerImage}:${ImageTag}"
  }
}
  
