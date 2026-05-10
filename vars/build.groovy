def call(String DockerImage, String ImageTag, String dockerHubUser){
  sh "docker build -t ${dockerHubUser}/${DockerImage}:${ImageTag} ."
}
                                           
